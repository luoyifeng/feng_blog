package com.jd.popc.service.surveyvisit;

import com.jd.com.base.enums.HouseStatusEnum;
import com.jd.common.constant.PopcConstant;
import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.*;
import com.jd.popc.mapper.mysql.*;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.houseinfo.domain.HouseBasicInfo;
import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.houseinfo.model.HiddenDanger;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.*;
import com.jd.service.surveyvisit.service.VisitCheckService;
import com.jd.service.wateruse.domain.WaterUseInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author yangsong on 2018/12/5.
 */
@Service
@Slf4j
public class VisitCheckServiceImpl implements VisitCheckService {

    private static SimpleDateFormat sdf = new SimpleDateFormat(PopcConstant.Date_Pattern_yyyyMMdd);

    @Resource
    private CheckListMapper checkListMapper;
    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private HouseBasicInfoMapper houseBasicInfoMapper;
    @Resource
    private HouseQueryInfoMapper houseQueryInfoMapper;
    @Resource
    private WaterUseInfoMapper waterUseInfoMapper;
    @Resource
    private CommonUtils commonUtils;

    /**
     * 反馈信息如数据库
     * @param checkFormResponse
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int saveVisitCheckForm(CheckFormResponse checkFormResponse) {
        CheckForm checkForm = new CheckForm();
        checkForm.setAbnormalInfoId(checkFormResponse.getAbnormalInfoId());

        // 核实结果入数据库
        if (StringUtils.isNotEmpty(checkFormResponse.getHouseStatus())) {
            if (checkFormResponse.getHouseStatus().equals(HouseStatusEnum.RENT_OUT.getStatusMsg())) {
                checkForm.setHouseRent(commonUtils.joinFieldsForResidentsInfo(checkFormResponse.getResidentsInfo()));
            }
            if (checkFormResponse.getHouseStatus().equals(HouseStatusEnum.OWNER_OCCUPATION.getStatusMsg())) {
                checkForm.setLodgePerson(commonUtils.joinFieldsForResidentsInfo(checkFormResponse.getResidentsInfo()));
            }
        }

        // 核实人员
        List<CheckPerson> checkPersons = checkFormResponse.getCheckPersons();
        if (checkPersons != null && checkPersons.size() > 0) {
            String checkPersonInfo = checkPersons.stream().map(checkPerson ->
                    StringUtils.trimToEmpty(checkPerson.getName()) + "," + StringUtils.trimToEmpty(checkPerson.getContactInfo())
            ).collect(Collectors.joining(";"));

            checkForm.setCheckPerson(checkPersonInfo);
        }

        // 走访人员
        List<String> visitPersons = checkFormResponse.getVisitPersons();
        if (visitPersons != null && visitPersons.size() > 0) {
            String visitPersonInfo = visitPersons.stream().collect(Collectors.joining(";"));
            checkForm.setVisitPerson(visitPersonInfo);
        }

        // 房屋状态
        checkForm.setHouseStatus(checkFormResponse.getHouseStatus());

        // 房屋隐患
        HiddenDanger hiddenDanger = checkFormResponse.getHiddenDanger();
        checkForm.setJudgeDanger(hiddenDanger.getJudgeDanger());
        checkForm.setHouseDanger(hiddenDanger.getHouseDangerOrig());
        checkForm.setHouseOtherDanger(hiddenDanger.getHouseOtherDanger());
        checkForm.setPersonDanger(hiddenDanger.getPersonDangerOrig());
        checkForm.setPersonOtherDanger(hiddenDanger.getPersonOtherDanger());

        checkForm.setCreateTime(new Date());
        checkForm.setUpdateTime(new Date());
        checkForm.setAuditConfirm(checkFormResponse.getAuditConfirm());
        int insertResult = checkListMapper.insert(checkForm);
        log.info("保存走访核实单后生成的ID:{}，成功与否:{}", checkForm.getId(), insertResult);

        return insertResult;
    }

    @Override
    public CheckFormResponse queryLastFeedbackById(Long proCollId, Boolean queryAll, int auditConfirm) {
        log.info("查询最后一次反馈记录 开始  proCollId："  + proCollId + "queryALL:" + queryAll + "auditConfirm" + auditConfirm);
        List<CheckForm> checkForm = checkListMapper.queryAllFeedbackById(proCollId, queryAll, auditConfirm);
        log.info("查询最后一次反馈记录 结束");
        CheckForm cf = new CheckForm();
        if (checkForm != null && checkForm.size() > 0) {
            cf = checkForm.get(0);
        }
        cf.setProCollId(proCollId);

        CheckFormResponse checkFormResponse = this.packageOneRecord(cf);
        return checkFormResponse;
    }

    /**
     * 调查走访-已处理异常-结果查询
     *
     * @param proCollId
     * @return
     */
    @Override
    public CheckResultResponse queryFeedbackResultByProCollId(Long proCollId) {
        // 基本信息
        if (StringUtils.isEmpty(String.valueOf(proCollId))) {
            return null;
        }
        CheckResultResponse checkResultResponse = new CheckResultResponse();
        AbnormalInfoRequest abnormalInfoRequest = new AbnormalInfoRequest();
        abnormalInfoRequest.setProCollId(proCollId);
        List<AbnormalInfo> abnormalInfos = abnormalInfoMapper.queryByCondition(abnormalInfoRequest);
        if (abnormalInfos != null && abnormalInfos.size() > 0) {
            checkResultResponse.setAbnormalInfo(abnormalInfos.get(0));
        } else {
            checkResultResponse.setAbnormalInfo(new AbnormalInfo());
        }

        //入住人员信息
        List<CheckForm> checkForm = checkListMapper.queryAllFeedbackById(proCollId, true, 1);
        if (checkForm == null || checkForm.size() == 0) {
            log.error("查询该房屋所有的走访核实反馈信息为空");
        } else {
            List<CheckFormResponse> checkFormResponses = checkForm.stream().map(cf -> this.wrappeResidents(cf)).collect(Collectors.toList());
            checkResultResponse.setCheckFormResponses(checkFormResponses);
            // 核实人员信息
            checkResultResponse.setCheckResidentInfo(checkFormResponses.get(0));
        }
        return checkResultResponse;
    }

    @Override
    public List<CheckFormResponse> queryAllFeedbackById(Long proCollId, Boolean queryAll) {
        if (proCollId == null) {
            return null;
        }

        List<CheckForm> checkForm = checkListMapper.queryAllFeedbackById(proCollId, queryAll, 1);
        if (checkForm == null || checkForm.size() == 0) {
            log.error("查询该房屋所有的走访核实反馈信息失败");
            return null;
        }

//        return checkForm.stream().map(cf -> this.packageOneRecord(cf)).collect(Collectors.toList());
        return checkForm.stream().map(cf -> this.wrappeResidents(cf)).collect(Collectors.toList());
    }

    @Override
    public Integer checkSurveyResultById(CheckForm checkForm) {
        //更新房屋状态
        // 为了保持全局统一，需要修改四个表
        // app_house_water_using_info 基本用水
        WaterUseInfo waterUseInfo = new WaterUseInfo();
        waterUseInfo.setProCollId(checkForm.getProCollId());
        waterUseInfo.setHouseStatus(checkForm.getHouseStatus());
        waterUseInfo.setHouseSpecialMark(checkForm.getHouseSpecialMark());
        waterUseInfoMapper.updateByProCollIdKeySelective(waterUseInfo);

        // app_houses_basic_infromation_da 房屋基本信息
        HouseBasicInfo houseBasicInfo = new HouseBasicInfo();
        houseBasicInfo.setHouseStatus(checkForm.getHouseStatus());
        houseBasicInfo.setProCollId(checkForm.getProCollId());
        houseBasicInfoMapper.updateByProCollIdSelective(houseBasicInfo);

        // app_houses_infromation_query_da 房屋信息查询
        HouseQueryInfo houseQueryInfo = new HouseQueryInfo();
        houseQueryInfo.setProCollId(checkForm.getProCollId());
        houseQueryInfo.setHouseStatus(checkForm.getHouseStatus());
        houseQueryInfoMapper.updateByProCollIdSelective(houseQueryInfo);

        //更新处理状态 app_survey_visit_abnormal_info 走访基本信息表
        AbnormalInfo abnormalInfo = new AbnormalInfo();
        abnormalInfo.setId(checkForm.getId());
        abnormalInfo.setUpdateTime(new Date());
        abnormalInfo.setHouseStatus(checkForm.getHouseStatus());
        abnormalInfo.setHouseSpecialMark(checkForm.getHouseSpecialMark());
        abnormalInfo.setSolveStatus(PopcConstant.Solve_Status_Yes);
        abnormalInfo.setProCollId(checkForm.getProCollId());
        int updateResult = abnormalInfoMapper.updateByProCollIdSelective(abnormalInfo);
        log.info("更新用水异常状态:{}, abnormalId:{}", updateResult, abnormalInfo.getId());

        return updateResult;
    }

    /**
     * 封装核实记录
     *
     * @param checkForm
     * @return
     */
    private CheckFormResponse packageOneRecord(CheckForm checkForm) {
        CheckFormResponse checkFormResponse = new CheckFormResponse();
        AbnormalInfo abnormalInfo = null;

        //有可能还未录入核实单走访信息
        if (checkForm.getId() != null) {
            // 创建时间
            checkFormResponse.setCreateTime(sdf.format(checkForm.getCreateTime()));

            CheckResult checkResult = new CheckResult();
            checkFormResponse.setCheckResult(checkResult);

            // 获取异常信息表
            log.info("获取异常信息开始");
            abnormalInfo = abnormalInfoMapper.selectByPrimaryKey(checkForm.getAbnormalInfoId());
//            checkFormResponse.setVisitReason(abnormalInfo.getAbnormalInfo());
            // 获取异常原因
            checkFormResponse.setVisitReason(abnormalInfo.getAbnormalType());
            log.info("获取异常信息结束");

            // 寄住人员
            String lodgePerson = checkForm.getLodgePerson();
            if (StringUtils.isNotEmpty(lodgePerson)) {
                checkResult.setLodgePersons(commonUtils.clonePerson(lodgePerson));
            }

            // 出租人员
            String houseRent = checkForm.getHouseRent();
            if (StringUtils.isNotEmpty(houseRent)) {
                checkResult.setRentPersons(commonUtils.clonePerson(houseRent));
            }
            checkResult.setOtherReason(checkForm.getOtherReason());

            //核实人员
            String checkPerson = checkForm.getCheckPerson();
            if (StringUtils.isNotEmpty(checkPerson)) {
                List<CheckPerson> checkPersonList = Stream.of(checkPerson.split(";", -1)).map(cp -> {
                    CheckPerson checkP = new CheckPerson();
                    String[] person = cp.split(",", -1);
                    if (person != null && person.length > 1) {
                        checkP.setName(person[0]);
                        checkP.setContactInfo(person[1]);
                    }
                    return checkP;
                }).collect(Collectors.toList());

                checkFormResponse.setCheckPersons(checkPersonList);
            }

            //走访人员
            String visitPerson = checkForm.getVisitPerson();
            if (StringUtils.isNotEmpty(visitPerson)) {
                List<String> visitPersons = Arrays.asList(visitPerson.split(";", -1));
                checkFormResponse.setVisitPersons(visitPersons);
            }
        } else {
            // 未录入核实走访单
            AbnormalInfoRequest request = new AbnormalInfoRequest();
            request.setProCollId(checkForm.getProCollId());
            request.setCurrentPage(0);
            request.setOffset(10);
            List<AbnormalInfo> abnormalInfos = abnormalInfoMapper.queryByCondition(request);
            if (abnormalInfos != null && abnormalInfos.size() > 0) {
                abnormalInfo = abnormalInfos.get(0);
                checkFormResponse.setVisitReason(abnormalInfo.getAbnormalInfo());
            }
        }

        if (abnormalInfo != null) {
            StringBuilder communityInfo = new StringBuilder();
            // 拼接房屋信息
            String communityDistrict = StringUtil.trimToNull(abnormalInfo.getCommunityDistrict());
            if (communityDistrict != null) {
                abnormalInfo.setCommunityName(abnormalInfo.getCommunityName() + "-" + abnormalInfo.getCommunityDistrict());
            }

            String houseUnit = StringUtil.trimToNull(abnormalInfo.getHouseUnit());
            String roomNum = StringUtil.trimToNull(abnormalInfo.getRoomNum());
            String apartNum = StringUtil.trimToNull(abnormalInfo.getApartmentNum());
            if (houseUnit != null && roomNum != null) {
                roomNum = houseUnit + "-" + roomNum;
            }

            if (apartNum != null) {
                roomNum = apartNum + "-" + roomNum;
            }

            if (roomNum == null) {
                roomNum = "";
            }
            communityInfo.append(StringUtils.trimToEmpty(abnormalInfo.getCommunityName()))
                    .append(roomNum)
                    .append("    ")
                    .append(StringUtils.trimToEmpty(abnormalInfo.getHouseStatus()));
            checkFormResponse.setHouseInfo(communityInfo.toString());

            // 拼接房主信息
            StringBuilder propertyInfo = new StringBuilder();
            String landlordName = StringUtil.trimToEmpty(abnormalInfo.getLandlordName());
            String landlordId = StringUtil.trimToEmpty(abnormalInfo.getLandlordId());
            String landlordPhone = StringUtil.trimToEmpty(abnormalInfo.getLandlordPhone());

            propertyInfo.append(landlordName)
                    .append(" ").append(landlordId)
                    .append("，").append("联系方式 ").append(landlordPhone);
            checkFormResponse.setHouseLandlordInfo(propertyInfo.toString());
        }

        // 获取入住人员信息 采用先查看走访没有则从基本信息获取,再拼装为字符串
        log.info("获取入住人员信息 开始");
        List<ResidentsInfoResponse> residentsInfo = commonUtils.getResidentsInfo(checkForm.getProCollId());
        log.info("获取入住人员信息 结束");
        checkFormResponse.setResidentsInfo(residentsInfo);
        if (residentsInfo != null) {
            checkFormResponse.setHouseResidentInfo(residentsInfo.stream().map(rdI -> {
                String name = StringUtil.trimToEmpty(rdI.getName());
                String sex = StringUtil.trimToEmpty(rdI.getSex());
                String nation = StringUtil.trimToEmpty(rdI.getNation());
                String idNumber = StringUtil.trimToEmpty(rdI.getIdNumber());
                String phone = StringUtil.trimToEmpty(rdI.getPhone());
                StringBuilder sb = new StringBuilder();
                sb.append(name).append(" ").append(sex).append("，").append(nation).append(idNumber).append("，")
                        .append("联系方式：").append(phone);
                return sb.toString();
            }).collect(Collectors.joining("；")));
        }

        // 房屋状态
        checkFormResponse.setHouseStatus(checkForm.getHouseStatus());

        // 房屋隐患
        HiddenDanger hiddenDanger = commonUtils.wrapperHiddenDanger(checkForm);
        checkFormResponse.setHiddenDanger(hiddenDanger);
        return checkFormResponse;
    }

    /**
     * 房屋走访页面结果包装
     *
     * @param checkForm
     * @return
     */
    private CheckFormResponse wrappeResidents(CheckForm checkForm) {
        CheckFormResponse checkFormResponse = new CheckFormResponse();
        AbnormalInfo abnormalInfo = null;
        if (checkForm != null || checkForm.getId() != null) {
            // 创建时间
            checkFormResponse.setCreateTime(sdf.format(checkForm.getCreateTime()));

            //走访原因
            abnormalInfo = abnormalInfoMapper.selectByPrimaryKey(checkForm.getAbnormalInfoId());
            checkFormResponse.setVisitReason(abnormalInfo.getAbnormalInfo());

            // 房屋隐患
            HiddenDanger hiddenDanger = commonUtils.wrapperHiddenDanger(checkForm);
            checkFormResponse.setHiddenDanger(hiddenDanger);

            // 入住人员
            List<ResidentsInfoResponse> visitCheckResident = commonUtils.getVisitCheckResident(checkForm);
            checkFormResponse.setResidentsInfo(visitCheckResident);

            // 核实人员及走访人员
            ArrayList<CheckPerson> checkPeopleList = new ArrayList<>();
            if (StringUtils.isNotEmpty(checkForm.getCheckPerson())) {
                CheckPerson checkPerson = commonUtils.getCheckPerson(checkForm.getCheckPerson());
                checkPeopleList.add(checkPerson);
            }
            checkFormResponse.setVisitPersons(StringUtils.isNotEmpty(checkForm.getVisitPerson())?Arrays.asList(checkForm.getVisitPerson().split(";", -1)):null);
            checkFormResponse.setCheckPersons(checkPeopleList);

            // 房屋特殊标签
            if (visitCheckResident != null && !visitCheckResident.isEmpty()) {
                List<String> idCardNos = visitCheckResident.stream().map(ResidentsInfoResponse::getIdNumber).distinct().collect(toList());
                List<String> personTags = new ArrayList<>();
                // 根据房屋身份证号集合获得房屋标签
                if (idCardNos != null || !idCardNos.isEmpty()) {
                    personTags = commonUtils.getPersonTags(idCardNos);
                }
                checkFormResponse.setPersonTags(personTags);
            }
        }
        return checkFormResponse;
    }
}
