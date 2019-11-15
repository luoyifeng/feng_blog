package com.jd.popc.service.wateruse;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.common.constant.PopcConstant;
import com.jd.common.utils.JsonUtil;
import com.jd.common.utils.NumberUtil;
import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.AbnormalInfoMapper;
import com.jd.popc.mapper.CommunityOfficerMapper;
import com.jd.popc.mapper.UserRightMapper;
import com.jd.popc.mapper.WaterUseInfoMapper;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.communityinfo.domain.CommunityInfo;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.domain.WaterUseInfoException;
import com.jd.service.wateruse.model.*;
import com.jd.service.wateruse.service.WaterUseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author yangsong on 2018/11/30.
 */
@Service
@Slf4j
public class WaterUseInfoServiceImpl implements WaterUseInfoService {

    @Resource
    private WaterUseInfoMapper waterUseInfoMapper;
    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private UserRightMapper userRightMapper;
    @Resource
    private CommunityOfficerMapper communityOfficerMapper;
    @Resource
    private CommonUtils commonUtils;

    @Override
    public ServiceResponse<List<WaterUseInfo>> queryWaterUseInfos(WaterUseInfoRequest request) {
        String officerNo = request.getOfficerNo();
        log.info("water use -- officerNo is:" + officerNo);
        if (StringUtils.isEmpty(officerNo)) {
            log.error("water use -- officerNo is empty");
            return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
        }

        Integer currentPage = request.getCurrentPage();
        request.setCurrentPage((request.getCurrentPage() - 1) * request.getOffset());

        WaterUseInfoQuery query = new WaterUseInfoQuery();
        //只卡近两个月比如 2018-10-01 to 2018-11-30
        LocalDate localDate = LocalDate.now();
        query.setStartDate(PopcConstant.yyyymmSDF.format(localDate.minus(1, ChronoUnit.MONTHS)));
        query.setEndDate(PopcConstant.yyyymmSDF.format(localDate));

        OfficerInfo officerInfo = userRightMapper.selectByOfficerNo(officerNo);
        if (officerInfo == null || officerInfo.getId() == null) {
            log.error("water use -- officerNo is not exist");
            return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
        }

        List<String> communityNames = Lists.newArrayList();
        if (!PopcConstant.Role_Admin.equalsIgnoreCase(officerInfo.getRole())) {
            CommunityOfficerRequest officerRequest = new CommunityOfficerRequest();
            officerRequest.setOfficerNo(officerNo);
            List<CommunityOfficerResponse> responseList = communityOfficerMapper.queryByCondition(officerRequest);
            if (responseList == null || responseList.size() == 0) {
                log.error("water use no authority community for officerNo:{}", officerNo);
                return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
            }

            communityNames = responseList.stream().map(CommunityOfficerResponse::getCommunityName).collect(toList());
        } else {
            List<CommunityInfo> allCommunity = communityOfficerMapper.queryCommunityByName(null);
            communityNames = allCommunity.stream().map(CommunityInfo::getCommunityName).collect(toList());
        }

        String communityName = StringUtil.trimToNull(request.getCommunityName());
        //当用户用某个小区作搜索条件时
        if (communityName != null) {
            String orElse = communityNames.stream().filter(name -> name.indexOf(communityName) > -1).findAny().orElse("");
            if ("".equalsIgnoreCase(orElse)) {
                return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
            } else {
                communityNames = Lists.newArrayList(orElse);
            }
        }
        query.setCommunityNames(communityNames);

        BeanUtils.copyProperties(request, query);
        log.info("query water use info by condition:{}", JsonUtil.toJson(query));

        List<WaterUseInfo> waterUseInfos = waterUseInfoMapper.queryByCondition(query);

        int delta = 1;
        while (CollectionUtils.isEmpty(waterUseInfos) && delta < 9) {
            //如果没有获取到数据，再往前推两个月
            query.setStartDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 2, ChronoUnit.MONTHS)));
            query.setEndDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 1, ChronoUnit.MONTHS)));
            waterUseInfos = waterUseInfoMapper.queryByCondition(query);

            delta += 2;
        }
        waterUseInfos = waterUseInfos.stream().map(waterUseInfo ->  {
            waterUseInfo.setMonthOnMonthGrowth(NumberUtil.decimalToPercent(NumberUtil.formatDecimal(waterUseInfo.getMonthOnMonthGrowth(), 0, 4)));
            waterUseInfo.setCoefficientVariation(NumberUtil.decimalToPercent(NumberUtil.formatDecimal(waterUseInfo.getCoefficientVariation(), 0, 4)));
            waterUseInfo.setStandardScore(NumberUtil.decimalToPercent(NumberUtil.formatDecimal(waterUseInfo.getStandardScore(), 0, 4)));
            waterUseInfo.setAvgWaterConsumption(NumberUtil.formatDecimal(waterUseInfo.getAvgWaterConsumption(), 0, 2));
            waterUseInfo.setHouseWaterStatus(StringUtil.trimToEmpty(waterUseInfo.getHouseWaterStatus()));

            //疑似空转租”判断（判断条件为上月用水为0，本月用水>0）
            String previousWaterConsumption = waterUseInfo.getPreviousWaterConsumption();
            String currentWaterConsumption = waterUseInfo.getCurrentWaterConsumption();
            if ("0.0".equals(previousWaterConsumption) && !"0.0".equals(currentWaterConsumption)) {
                waterUseInfo.setSuspectRent(true);
            }

            // 疑似空房购物判断（依据：房屋状态为空置且购物次数>0）
            Long shoppingTimes = waterUseInfo.getShoppingTimes();
            String houseStatus = waterUseInfo.getHouseStatus();
            if (shoppingTimes == null) {
                shoppingTimes = 0L;
            }
            if (StringUtils.isNotEmpty(houseStatus)) {
                if (houseStatus.equals("空置") && shoppingTimes > 0) {
                    waterUseInfo.setEmptyShopping("有");
                } else {
                    waterUseInfo.setEmptyShopping("无");
                }
            }

            String landlordPhone = StringUtil.trimToNull(waterUseInfo.getLandlordPhone());
            if (landlordPhone == null) {
                waterUseInfo.setLandlordPhone("--");
            }

//            String communityDistrict = StringUtil.trimToNull(waterUseInfo.getCommunityDistrict());
//            if(communityDistrict != null) {
//                waterUseInfo.setCommunityName(waterUseInfo.getCommunityName() + "-" + waterUseInfo.getCommunityDistrict());
//            }

            /*String houseUnit = StringUtil.trimToNull(waterUseInfo.getHouseUnit());
            String roomNum = StringUtil.trimToNull(waterUseInfo.getRoomNum());
            if (houseUnit != null && roomNum != null) {
                waterUseInfo.setRoomNum(StringUtils.join(houseUnit, "-", roomNum));
            } else {
                waterUseInfo.setRoomNum(houseUnit != null ? houseUnit : (roomNum == null ? "--" : roomNum));
            }*/

            if (StringUtils.isEmpty(waterUseInfo.getRoomNum())) {
                waterUseInfo.setRoomNum("—");
            }
            String landlordName = StringUtil.trimToEmpty(waterUseInfo.getLandlordName());
            waterUseInfo.setLandlordName(landlordName);

            String landlordId = StringUtil.trimToEmpty(waterUseInfo.getLandlordId());
            waterUseInfo.setLandlordId(landlordId);

            return waterUseInfo;
        }).collect(Collectors.toList());

        Integer totalSize = waterUseInfoMapper.queryCountByCondition(query);
        return ServiceResponse.successWithPageInfo(waterUseInfos, currentPage, totalSize);
    }

    @Override
    public int insert(WaterUseInfo record) {
        return waterUseInfoMapper.insert(record);
    }

    /**
     * 判定用水异常
     *
     * @param arrayParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean judgeAbnormal(ArrayParam arrayParam) {
        List<Long> ids = arrayParam.getIds();
        String officerNo = arrayParam.getOfficerNo();
        if (ids == null || ids.size() == 0) {
            log.error("judge abnormal error ids.size is 0:{}", officerNo);
            return false;
        }

        for (Long id : ids) {
            //设置调查走访--异常信息表
            WaterUseInfo waterUseInfo = waterUseInfoMapper.selectByPrimaryKey(id);
            AbnormalInfo abnormalInfo = new AbnormalInfo();
            abnormalInfo.setProCollId(waterUseInfo.getProCollId());
            abnormalInfo.setAbnormalType(arrayParam.getAbnormalInfo());
//            abnormalInfo.setAbnormalInfo("Z分数超出百分比 " + NumberUtil.decimalToPercent(NumberUtil.formatDecimal(waterUseInfo.getStandardScore(), 0, 4)));
            abnormalInfo.setAbnormalInfo(arrayParam.getAbnormalInfo());
            abnormalInfo.setCommunityDistrict(waterUseInfo.getCommunityDistrict());
            abnormalInfo.setCommunityName(waterUseInfo.getCommunityName());
            abnormalInfo.setApartmentNum(waterUseInfo.getApartmentNum());
            abnormalInfo.setHouseUnit(waterUseInfo.getHouseUnit());
            abnormalInfo.setRoomNum(waterUseInfo.getRoomNum());
            abnormalInfo.setHouseStatus(waterUseInfo.getHouseStatus());
            abnormalInfo.setLandlordName(waterUseInfo.getLandlordName());
            abnormalInfo.setLandlordId(waterUseInfo.getLandlordId());
            abnormalInfo.setLandlordPhone(waterUseInfo.getLandlordPhone());
            abnormalInfo.setJudgeAbnormalTime(PopcConstant.yyyymmddSDF.format(LocalDate.now()));
            abnormalInfo.setSolveStatus(PopcConstant.Solve_Status_No);
            abnormalInfo.setShoppingTimes(waterUseInfo.getShoppingTimes());
            abnormalInfo.setStandardScore(waterUseInfo.getStandardScore());
            abnormalInfo.setHouseSpecialMark(waterUseInfo.getHouseSpecialMark());

            String officerName = "系统", officerPhone = "";
            if (officerNo != null) {
                OfficerInfo officerInfo = userRightMapper.selectByOfficerNo(officerNo);
                officerName = officerInfo.getOfficerName();
                officerPhone = officerInfo.getOfficerPhone();
            }
            abnormalInfo.setOfficerName(officerName);
            abnormalInfo.setOfficerPhone(officerPhone);
            int inserResult = abnormalInfoMapper.insertSelective(abnormalInfo);
            log.info("judge abnormal insert to table, id:{}, insertResult:{}", id, inserResult);

            //更新用水异常判定表--异常状态
            WaterUseInfo wui = new WaterUseInfo();
            wui.setId(id);
            wui.setHouseWaterStatus(PopcConstant.House_Water_Status);
            wui.setJudgeAbnormalTime(PopcConstant.yyyymmddSDF.format(LocalDate.now()));
            int updateResult = waterUseInfoMapper.updateByPrimaryKeySelective(wui);
            log.info("judge abnormal update water use table, id:{}, updateResult:{}", id, updateResult);
        }
        return true;
    }

    @Override
    public TrendVue queryWaterTrendByProCollId(Long proCollId) {
        List<WaterTrend> finalTrends = Lists.newArrayList();
        LocalDate localDate = LocalDate.now();
        List<String> months = Lists.newArrayList();
        //先获取到近一年所有日期
        IntStream.range(0, 12).forEach(i -> {
            LocalDate plus = localDate.minus(i, ChronoUnit.MONTHS);
            months.add(PopcConstant.yyyymmSDF.format(plus));
        });

        List<WaterTrend> waterTrends = Lists.newArrayList();
        final List<String> matchMonths = Lists.newArrayList();
        if (proCollId != null) {
            waterTrends = waterUseInfoMapper.queryWaterTrendByProCollId(proCollId);
            matchMonths.addAll(waterTrends.stream().map(WaterTrend::getDate).collect(toList()));
        }

        //数据库里不存在的数据设置默认值
//        months.stream().forEach(month -> {
//            if(!matchMonths.contains(month)) {
//                WaterTrend trend = new WaterTrend();
//                trend.setDate(month);
//                trend.setConsumption(0.0);
//                finalTrends.add(trend);
//            }
//        });

        //合并已有的数据
        finalTrends.addAll(waterTrends);
        finalTrends.sort(Comparator.comparing(WaterTrend::getDate));

        TrendVue trendVue = new TrendVue();
        TrendVue.Dimensions dimensions = new TrendVue.Dimensions();
        trendVue.setDimensions(dimensions);
        dimensions.setName("日期");
        dimensions.setData(finalTrends.stream().map(WaterTrend::getDate).collect(toList()));

        List<TrendVue.Measures> measures = Lists.newArrayList();
        trendVue.setMeasures(measures);
        TrendVue.Measures measure = new TrendVue.Measures();
        measure.setName("用水量（吨）");
        measure.setData(finalTrends.stream().map(WaterTrend::getConsumption).collect(toList()));
        measures.add(measure);

        return trendVue;
    }

    @Override
    public void autoJudgeAbnormal() {
        ArrayParam arrayParam = new ArrayParam();
//        arrayParam.setOfficerNo(PopcConstant.Role_Admin);
        WaterUseInfoException wie = new WaterUseInfoException();
        //只卡近两个月比如 2018-10-01 to 2018-11-30 找最大分区
        LocalDate localDate = LocalDate.now();
        wie.setStartDate(PopcConstant.yyyymmSDF.format(localDate.minus(1, ChronoUnit.MONTHS)));
        wie.setEndDate(PopcConstant.yyyymmSDF.format(localDate));
        WaterUseInfoQuery query = new WaterUseInfoQuery();
        query.setCurrentPage(0);
        query.setOffset(10);
        List<WaterUseInfo> waterUseInfos = waterUseInfoMapper.queryByCondition(query);

        int delta = 1;
        while (CollectionUtils.isEmpty(waterUseInfos) && delta < 9) {
            //如果没有获取到数据，再往前推两个月
            query.setStartDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 2, ChronoUnit.MONTHS)));
            wie.setStartDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 2, ChronoUnit.MONTHS)));
            query.setEndDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 1, ChronoUnit.MONTHS)));
            wie.setEndDate(PopcConstant.yyyymmSDF.format(localDate.minus(delta + 1, ChronoUnit.MONTHS)));
            waterUseInfos = waterUseInfoMapper.queryByCondition(query);
            delta += 2;
        }

        // 1. 查询房东信息为空的id集合,并执行判断
        wie.setLandlord(1);
        wie.setCurrentWaterConsumption(0);
        List<Long> emptyLandLoadIds = waterUseInfoMapper.queryIdsByAbnomalCondition(wie);

        arrayParam.setIds(emptyLandLoadIds);
        arrayParam.setAbnormalInfo("房东信息异常");
        judgeAbnormal(arrayParam);
        // 2. 查询用水信息为空的id集合
        wie.setLandlord(0);
        wie.setCurrentWaterConsumption(1);
        List<Long> emptyWaterIds = waterUseInfoMapper.queryIdsByAbnomalCondition(wie);
        arrayParam.setIds(emptyWaterIds);
        arrayParam.setAbnormalInfo("用水异常");
        judgeAbnormal(arrayParam);
        // 3. 只有房东信息数据缺失，执行判断异常方法
        wie.setLandlord(1);
        wie.setCurrentWaterConsumption(1);
        List<Long> emptyWaterAndEmptyLandLoadIds = waterUseInfoMapper.queryIdsByAbnomalCondition(wie);
        arrayParam.setIds(emptyWaterAndEmptyLandLoadIds);
        arrayParam.setAbnormalInfo("房东信息异常,用水异常");
        judgeAbnormal(arrayParam);
    }
}
