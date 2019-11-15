package com.jd.popc.service.houseinfo;

import com.google.common.collect.Lists;
import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.*;
import com.jd.popc.mapper.mysql.*;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.houseinfo.domain.HouseBasicInfo;
import com.jd.service.houseinfo.domain.HouseDealInfo;
import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.houseinfo.model.HiddenDanger;
import com.jd.service.houseinfo.model.HouseBasicInfoResponse;
import com.jd.service.houseinfo.model.HouseQueryRequest;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.houseinfo.service.HouseInfoService;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.wateruse.domain.WaterUseInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author yangsong on 2018/12/6.
 */
@Slf4j
@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    @Resource
    private HouseQueryInfoMapper houseQueryInfoMapper;
    @Resource
    private HouseBasicInfoMapper houseBasicInfoMapper;
    @Resource
    private WaterUseInfoMapper waterUseInfoMapper;
    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private HouseDealInfoMapper houseDealInfoMapper;
    @Resource
    private CommonUtils commonUtils;
    @Resource
    private CheckListMapper checkListMapper;

    @Override
    public List<HouseQueryInfo> queryByCondition(HouseQueryRequest houseQueryRequest) {
        houseQueryRequest.setCurrentPage((houseQueryRequest.getCurrentPage() - 1) * houseQueryRequest.getOffset());
        List<HouseQueryInfo> houseQueryInfos = houseQueryInfoMapper.queryByCondition(houseQueryRequest);
        houseQueryInfos = houseQueryInfos.stream().map(houseQueryInfo -> {
            houseQueryInfo.setLandlordName(StringUtil.trimToEmpty(houseQueryInfo.getLandlordName()));

            houseQueryInfo.setLandlordId(StringUtil.trimToEmpty(houseQueryInfo.getLandlordId()));

            String landlordPhone = houseQueryInfo.getLandlordPhone();
            if ("".equals(StringUtil.trimToEmpty(landlordPhone))) {
                houseQueryInfo.setLandlordPhone("--");
            }

//            String communityDistrict = houseQueryInfo.getCommunityDistrict();
//            if(StringUtil.trimToNull(communityDistrict) != null) {
//                houseQueryInfo.setCommunityName(houseQueryInfo.getCommunityName() + "-" + houseQueryInfo.getCommunityDistrict());
//            }

            //String houseUnit = StringUtil.trimToNull(houseQueryInfo.getHouseUnit());
            String roomNum = StringUtil.trimToNull(houseQueryInfo.getRoomNum());
            if (roomNum != null) {
                    houseQueryInfo.setRoomNum(roomNum);
            } else {
                houseQueryInfo.setRoomNum(roomNum == null ? "--" : roomNum);
            }
            //是否存在隐患，1表示存在，0表示不存在
            String houseDanger = StringUtil.trimToNull(houseQueryInfo.getHouseDanger());
            if ("1".equals(houseDanger)) {
                    houseQueryInfo.setHouseDanger("存在");
            } else if("0".equals(houseDanger)) {
            	    houseQueryInfo.setHouseDanger("不存在");
            }else {
            	    houseQueryInfo.setHouseDanger("--");
            }
            
            
            String apartmentNum = StringUtil.trimToNull(houseQueryInfo.getApartmentNum());
            if (apartmentNum == null) {
                houseQueryInfo.setApartmentNum("--");
            }

            return houseQueryInfo;
        }).collect(Collectors.toList());

        return houseQueryInfos;
    }

    @Override
    public Integer queryCountByCondition(HouseQueryRequest houseQueryRequest) {
        return houseQueryInfoMapper.queryCountByCondition(houseQueryRequest);
    }

    /**
     * 房屋基本信息
     * @param proCollId
     * @return
     */
    @Override
    public HouseBasicInfoResponse
    queryHouseBasicInfoByProCollId(Long proCollId) {
        HouseBasicInfoResponse houseBasicInfoResponse = new HouseBasicInfoResponse();
        if (proCollId == null) {
            return houseBasicInfoResponse;
        }

        List<HouseBasicInfo> houseBasicInfos = houseBasicInfoMapper.selectByProCollId(proCollId);

        //基本信息
        HouseBasicInfo houseBasicInfo = null;
        if (houseBasicInfos != null && !houseBasicInfos.isEmpty()) {
//            String communityDistrict = StringUtil.trimToNull(houseBasicInfo.getCommunityDistrict());
//            if (communityDistrict != null) {
//                houseBasicInfo.setCommunityName(houseBasicInfo.getCommunityName() + "-" + communityDistrict);
//            }
            houseBasicInfo = houseBasicInfos.get(0);
            houseBasicInfoResponse.setBasicInfo(houseBasicInfos);

//            List<String> residentInfo = Lists.newArrayList();
//            ArrayList<HouseBasicInfo> removeDuplicateInfos = houseBasicInfos.stream().collect(Collectors.collectingAndThen(
//                    Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(HouseBasicInfo::getResidentId))), ArrayList::new));
//            removeDuplicateInfos.stream().forEach(hbi -> {
//                StringBuilder sb = new StringBuilder();
//
//                String residentName = StringUtil.trimToEmpty(hbi.getResidentName());
//                String residentId = StringUtil.trimToEmpty(hbi.getResidentId());
//                String residentSex = StringUtil.trimToNull(hbi.getResidentSex());
//                if (residentSex != null) {
//                    residentSex = StringUtils.equals("1", residentSex) ? "女" : "男";
//                } else {
//                    residentSex = "--";
//                }
//
//                sb.append(residentName).append("，").append("身份证号：").append(residentId).append("，")
//                        .append("性别：").append(residentSex).append("，")
//                        .append("出生年月：").append(StringUtil.trimToNull(hbi.getBirthDate()) == null ? "--" : hbi.getBirthDate()).append("；")
//                        .append("手机号：").append(StringUtil.trimToNull(hbi.getContactInfo()) == null ? "--" : hbi.getContactInfo());
//                residentInfo.add(sb.toString());
//            });
        }
        //入住人员信息
        List<ResidentsInfoResponse> residentsInfoList = commonUtils.getResidentsInfo(proCollId);
        if (residentsInfoList != null && !residentsInfoList.isEmpty()) {
            List<String> idCardNoList = residentsInfoList.stream().map(ResidentsInfoResponse::getIdNumber).distinct().collect(toList());
            List<String> personTags = commonUtils.getPersonTags(idCardNoList);
            houseBasicInfoResponse.setPersonTags(personTags);
        }
        //针对每个入住人员信息填充案底情况
        if (residentsInfoList != null && residentsInfoList.size() != 0) {
            for (ResidentsInfoResponse re : residentsInfoList) {
                List<String> personTags = new ArrayList<>();
                personTags = commonUtils.getPersonTags((Collections.singletonList(re.getIdNumber())));
                re.setCaseBackGround(StringUtils.join(personTags.toArray(), ','));
            }
        }
        houseBasicInfoResponse.setResidentInfo(residentsInfoList);

        //房屋隐患
        HiddenDanger hiddenDanger = commonUtils.getHiddenDanger(proCollId);
        houseBasicInfoResponse.setHiddenDanger(hiddenDanger);

        //交易信息
        List<HouseDealInfo> houseDealInfos = houseDealInfoMapper.selectByProCollId(proCollId);
        List<String> dealInfo = Lists.newArrayList();
        if (houseDealInfos == null || houseDealInfos.size() == 0 || StringUtil.trimToNull(houseDealInfos.get(0).getLandlordId()) == null) {
            //数据为空时用基本信息
            //这个地方取的是房东的信息
            StringBuilder sb = new StringBuilder();
            if (houseBasicInfos != null && !houseBasicInfos.isEmpty()) {
                sb.append(StringUtil.trimToEmpty(houseBasicInfo.getLandlordName())).append("，")
                        .append("身份证号：").append(StringUtil.trimToEmpty(houseBasicInfo.getLandlordId())).append("，")
                        .append("产权证号：").append(StringUtil.trimToEmpty(houseBasicInfo.getPropertyRightCertificate()));
                dealInfo.add(sb.toString());
            }

        } else {
            // 这里取的是交易信息表中的数据
            StringBuilder certificateInfo = new StringBuilder();
            certificateInfo.append("产权证号：").append(StringUtil.trimToEmpty(houseDealInfos.get(0).getPropertyRightCertificateNumber()));
            houseDealInfos.stream().forEach(houseDealInfo -> {
                StringBuilder sb = new StringBuilder();
                sb.append(StringUtil.trimToEmpty(houseDealInfo.getPropertyIssueDate())).append("，")
                        .append(StringUtil.trimToEmpty(houseDealInfo.getLandlordName())).append("，")
                        .append("身份证号：").append(StringUtil.trimToEmpty(houseDealInfo.getLandlordId())).append("，")
                        .append("产权证号：").append(StringUtil.trimToEmpty(houseDealInfo.getPropertyRightCertificateNumber()));
                dealInfo.add(sb.toString());
            });
        }
        houseBasicInfoResponse.setDealInfo(dealInfo);
        return houseBasicInfoResponse;
    }

    @Override
    public Integer updateHouseBasicInfo(HouseBasicInfo houseBasicInfo) {
        // 为了保持全局统一，需要修改四个表
        // app_house_water_using_info 基本用水
        WaterUseInfo waterUseInfo = new WaterUseInfo();
        waterUseInfo.setProCollId(houseBasicInfo.getProCollId());
        waterUseInfo.setLandlordName(houseBasicInfo.getLandlordName());
        waterUseInfo.setLandlordId(houseBasicInfo.getLandlordId());
        waterUseInfo.setHouseStatus(houseBasicInfo.getHouseStatus());
        waterUseInfoMapper.updateByProCollIdKeySelective(waterUseInfo);

        // app_houses_basic_infromation_da 房屋基本信息
        int resultId = houseBasicInfoMapper.updateByProCollIdSelective(houseBasicInfo);

        // app_houses_infromation_query_da 房屋信息查询
        HouseQueryInfo houseQueryInfo = new HouseQueryInfo();
        houseQueryInfo.setProCollId(houseBasicInfo.getProCollId());
        houseQueryInfo.setLandlordPhone(houseBasicInfo.getLandlordPhone());
        houseQueryInfo.setLandlordId(houseBasicInfo.getLandlordId());
        houseQueryInfo.setHouseStatus(houseBasicInfo.getHouseStatus());
        houseQueryInfoMapper.updateByProCollIdSelective(houseQueryInfo);

        // app_survey_visit_abnormal_info 走访基本信息表
        AbnormalInfo abnormalInfo = new AbnormalInfo();
        abnormalInfo.setProCollId(houseBasicInfo.getProCollId());
        abnormalInfo.setLandlordName(houseBasicInfo.getLandlordName());
        abnormalInfo.setLandlordId(houseBasicInfo.getLandlordId());
        abnormalInfo.setHouseStatus(houseBasicInfo.getHouseStatus());
        abnormalInfoMapper.updateByProCollIdSelective(abnormalInfo);

        return resultId;
    }
}
