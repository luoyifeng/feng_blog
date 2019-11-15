package com.jd.popc.service.utils;

import com.jd.com.base.enums.HouseDangerEnum;
import com.jd.com.base.enums.HouseStatusEnum;
import com.jd.com.base.enums.PersonDangerEnum;
import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.CheckListMapper;
import com.jd.popc.mapper.HouseBasicInfoMapper;
import com.jd.popc.mapper.oracle.ZdryglxxfoMapper;
import com.jd.service.houseinfo.domain.HouseBasicInfo;
import com.jd.service.houseinfo.model.HiddenDanger;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.CheckPerson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author:luoyifeng
 **/
@Service
@Slf4j
public class CommonUtils {
    @Resource
    private HouseBasicInfoMapper houseBasicInfoMapper;
    @Resource
    private CheckListMapper checkListMapper;
    @Resource
    private ZdryglxxfoMapper zdryglxxfoMapper;

    /**
     * 将入住人员的字符串格式转化为入住人员对象(不包括走访人员和核实人员)
     * @param person
     * @return
     */
    public List<ResidentsInfoResponse> clonePerson(String person) {
        return Stream.of(person.split(";", -1)).map(str -> {
            ResidentsInfoResponse response = new ResidentsInfoResponse();
            String[] lps = str.split(",", -1);
            if(lps != null && lps.length >= 10) {
                response.setName(lps[0]);
                response.setRelation(lps[1]);
                response.setSex(lps[2]);
                response.setNation(lps[3]);
                response.setIdNumber(lps[4]);
                response.setPermanentAddress(lps[5]);
                response.setOutflow(lps[6]);
                response.setOutflowInfo(lps[7]);
                response.setWorkPlace(lps[8]);
                response.setPost(lps[9]);
                response.setPhone(lps[10]);
                response.setVisitDate(lps[11]);
//                response.setCheckPerson(lps[12]);
//                response.setVisitPerson(lps[13]);

                // 单独获得案底情况
                if (StringUtils.isNotEmpty(response.getIdNumber())) {
                    List<String> personTags = this.getPersonTags(Collections.singletonList(response.getIdNumber()));
                    response.setCaseBackGround(StringUtils.join(personTags, ','));
                }
            }
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 将入住人员的集合格式转化为入住人员字符串(不包括走访人员和核实人员)
     * @param residentsInfoResponses
     * @return
     */
    public String joinFieldsForResidentsInfo(List<ResidentsInfoResponse> residentsInfoResponses) {
        String lodgePersonInfo = residentsInfoResponses.stream().map(residentInfo -> {
            StringBuffer sb = new StringBuffer();
            sb.append(StringUtils.trimToEmpty(residentInfo.getName())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getRelation())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getSex())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getNation())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getIdNumber())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getPermanentAddress())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getOutflow())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getOutflowInfo())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getWorkPlace())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getPost())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getPhone())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getVisitDate()));
                    /*.append(StringUtils.trimToEmpty(residentInfo.getCheckPerson())).append(",")
                    .append(StringUtils.trimToEmpty(residentInfo.getVisitPerson())).append(",")*/
            return sb.toString();
        }).collect(Collectors.joining(";"));
        return lodgePersonInfo;
    }

    /**
     * 获取入住人员信息 通用方法
     * @param proCollId
     * @return
     */
    public List<ResidentsInfoResponse> getResidentsInfo (Long proCollId) {
        // 首先判断该id在走访记录中是否存在
        List<CheckForm> checkForms = checkListMapper.queryAllFeedbackById(proCollId, false, 0);
        if (checkForms != null && checkForms.size() != 0) {
            CheckForm checkForm = checkForms.get(0);
            return getVisitCheckResident(checkForm);
        } else {
            // 不存在则从基本信息表中获取，判断房屋状态，以此来获取入住人员信息
            List<HouseBasicInfo> houseBasicInfos = houseBasicInfoMapper.selectByProCollId(proCollId);
            // 如果不为空
            if (houseBasicInfos != null && houseBasicInfos.size() > 0) {
                ArrayList<ResidentsInfoResponse> residentsInfoResponses = new ArrayList<>();

                // 去除入住人员身份证号不存在的以及重复的
                ArrayList<HouseBasicInfo> removeDuplicateInfos = houseBasicInfos.stream().filter(info -> StringUtils.isNotEmpty(info.getResidentId()))
                        .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(HouseBasicInfo::getResidentId))), ArrayList::new));
                removeDuplicateInfos.stream().forEach(hbi -> {
                    ResidentsInfoResponse response = new ResidentsInfoResponse();
                    response.setName(StringUtil.trimToEmpty(hbi.getResidentName()));
                    response.setPhone(hbi.getContactInfo());
                    String residentSex = StringUtil.trimToNull(hbi.getResidentSex());
                    if (residentSex != null) {
                        residentSex = StringUtils.equals("1", residentSex) ? "女" : "男";
                    } else {
                        residentSex = "--";
                    }
                    response.setSex(residentSex);
                    response.setIdNumber(StringUtil.trimToEmpty(hbi.getResidentId()));

                    /**********后期补充***************/
                    response.setNation("--");
                    response.setPermanentAddress("--");
                    response.setOutflow("--");
                    response.setOutflowInfo("--");
                    response.setRelation("--");
                    /****************************/
                    residentsInfoResponses.add(response);
                });
                return residentsInfoResponses;
            } else { //如果基本信息表中也没有数据则返回空
                return null;
            }
        }
    }

    /**
     * 只获取走访表中的入住人员信息并补充核实人员及走访人员信息
     * @param checkForm
     * @return
     */
    public List<ResidentsInfoResponse> getVisitCheckResident(CheckForm checkForm) {
        String personInfo = "";
        if (StringUtils.isEmpty(checkForm.getHouseStatus())) {
            return null;
        }
        if (checkForm.getHouseStatus().equals(HouseStatusEnum.OWNER_OCCUPATION.getStatusMsg())) { //自住
            personInfo = checkForm.getLodgePerson();
            if (StringUtils.isEmpty(personInfo)) {
                return null;
            }
            List<ResidentsInfoResponse> residentsInfoResponses = this.clonePerson(personInfo);
            // 补充核实人员和走访人员
            String visitPerson = checkForm.getVisitPerson();
            String checkPersonName = "";
            String checkPersonPhone = "";
            if (StringUtils.isNotEmpty(checkForm.getCheckPerson())) {
                CheckPerson checkPerson = this.getCheckPerson(checkForm.getCheckPerson());
                checkPersonName = checkPerson.getName();
                checkPersonPhone = checkPerson.getContactInfo();
            }

            for (ResidentsInfoResponse response : residentsInfoResponses) {
                response.setCheckPerson(checkPersonName);
                response.setCheckPersonPhone(checkPersonPhone);
                response.setVisitPerson(visitPerson);
            }
            return residentsInfoResponses;
        }

        if (checkForm.getHouseStatus().equals(HouseStatusEnum.RENT_OUT.getStatusMsg())) { //出租
            personInfo = checkForm.getHouseRent();
            if (StringUtils.isEmpty(personInfo)) {
                return null;
            }
            List<ResidentsInfoResponse> residentsInfoResponses = this.clonePerson(personInfo);
            // 补充核实人员和走访人员
            String visitPerson = checkForm.getVisitPerson();
            String checkPersonName = "";
            String checkPersonPhone = "";
            if (StringUtils.isNotEmpty(checkForm.getCheckPerson())) {
                CheckPerson checkPerson = this.getCheckPerson(checkForm.getCheckPerson());
                checkPersonName = checkPerson.getName();
                checkPersonPhone = checkPerson.getContactInfo();
            }
            for (ResidentsInfoResponse response : residentsInfoResponses) {
                response.setCheckPerson(checkPersonName);
                response.setCheckPersonPhone(checkPersonPhone);
                response.setVisitPerson(visitPerson);
            }
            return residentsInfoResponses;
        }

        if (checkForm.getHouseStatus().equals(HouseStatusEnum.LEAVE_UNUSED.getStatusMsg())) { //空置
            return null;
        }
        return null;
    }

    /**
     * 核实人员字符串转化为对象
     * @param checkPersonStr
     * @return
     */
    public CheckPerson getCheckPerson (String checkPersonStr) {
        String[] checkPersonOne = checkPersonStr.split(",", -1);
        CheckPerson checkPerson = new CheckPerson();
        checkPerson.setName(checkPersonOne[0]);
        checkPerson.setContactInfo(checkPersonOne[1]);
        return checkPerson;
    }
    /**
     * 获取房屋隐患
     * @param proCollId
     * @return
     */
    public HiddenDanger getHiddenDanger(Long proCollId) {
        HiddenDanger hiddenDanger = new HiddenDanger();
        // 首先判断该id在走访记录中是否存在
        List<CheckForm> checkForms = checkListMapper.queryAllFeedbackById(proCollId, false, 0);
        String personInfo = "";
        if (checkForms != null && checkForms.size() != 0) {
            CheckForm checkForm = checkForms.get(0);
            hiddenDanger = wrapperHiddenDanger(checkForm);
        } else {
            hiddenDanger.setHouseDanger("暂无");
            hiddenDanger.setPersonDanger("暂无");
        }
        return hiddenDanger;
    }

    /**
     * 房屋隐患封装
     * @param checkForm
     * @return
     */
    public HiddenDanger wrapperHiddenDanger(CheckForm checkForm) {
        HiddenDanger hiddenDanger = new HiddenDanger();
        hiddenDanger.setPersonDangerOrig(checkForm.getPersonDanger());
        hiddenDanger.setHouseDangerOrig(checkForm.getHouseDanger());
        hiddenDanger.setPersonOtherDanger(checkForm.getPersonOtherDanger());
        hiddenDanger.setHouseOtherDanger(checkForm.getHouseOtherDanger());
        hiddenDanger.setJudgeDanger(checkForm.getJudgeDanger());
        // 判断是否存在隐患
        String judgeDanger = checkForm.getJudgeDanger();
        if (StringUtils.isNotEmpty(judgeDanger)) {
            if (judgeDanger.equals("1")) {
                // 存在隐患
                String personDanger = checkForm.getPersonDanger();
                if (StringUtils.isNotEmpty(personDanger)) {
                    ArrayList<String> personDangerList = new ArrayList<>();
                    Arrays.stream(personDanger.split(",", -1)).forEach(item -> {
                        if (item.equals(String.valueOf(PersonDangerEnum.danger5.getStatusCode()))) {
                            personDangerList.add(checkForm.getPersonOtherDanger());
                        }
                        if (StringUtils.isNotEmpty(item) && !item.equals(String.valueOf(PersonDangerEnum.danger5.getStatusCode()))) {
                            personDangerList.add(PersonDangerEnum.getShow(Integer.parseInt(item)));
                        }
                    });
                    hiddenDanger.setHouseDanger(StringUtils.join(personDangerList.toArray(), ","));
                } else {
                    hiddenDanger.setHouseDanger("暂无");
                }


                String houseDanger = checkForm.getHouseDanger();
                if (StringUtils.isNotEmpty(houseDanger)) {
                    ArrayList<String> houseDangerList = new ArrayList<>();
                    Arrays.stream(houseDanger.split(",", -1)).forEach(item -> {
                        if (item.equals(String.valueOf(HouseDangerEnum.danger6.getStatusCode()))) {
                            houseDangerList.add(checkForm.getHouseOtherDanger());
                        }
                        if (StringUtils.isNotEmpty(item) && !item.equals(String.valueOf(HouseDangerEnum.danger6.getStatusCode()))) {
                            houseDangerList.add(HouseDangerEnum.getShow(Integer.parseInt(item)));
                        }
                    });
                    hiddenDanger.setPersonDanger(StringUtils.join(houseDangerList.toArray(), ","));
                } else {
                    hiddenDanger.setPersonDanger("暂无");
                }

            }
            if (judgeDanger.equals("0")) {
                hiddenDanger.setHouseDanger("暂无");
                hiddenDanger.setPersonDanger("暂无");
            }
        } else {
            hiddenDanger.setHouseDanger("暂无");
            hiddenDanger.setPersonDanger("暂无");
        }
        return hiddenDanger;
    }

    /**
     * 根据身份证号查询人员标签属性
     * @param idCardNos
     * @return
     */
    public List<String> getPersonTags(List<String> idCardNos) {
        HashSet result = new HashSet();
        for (String idcardNo : idCardNos) {
            log.info("调用人员属性接口 开始");
//            List<String> involveds = zdryglxxfoMapper.queryInvolved(idcardNo);
            List<String> involveds = ConnectOracle.queryInvolved(idcardNo);
            log.info("调用人员属性接口 结束");
            if (involveds.size() > 0 && StringUtils.isNotEmpty(involveds.get(0))) {
                result.add("涉案人员");
            }
            log.info("调用人员属性接口 开始");
//            List<String> keyOrRisks = zdryglxxfoMapper.queryKeyOrRisk(idcardNo);
            List<String> keyOrRisks =  ConnectOracle.queryKeyOrRisk(idcardNo);
            log.info("调用人员属性接口 结束");
            if (keyOrRisks.size() == 0) {
                continue;
            }
            for (String tag : keyOrRisks) {
                if (tag.equals("1")) {//重点人员
                    result.add("重点人员");
                }
                if (tag.equals("2")) { // 风险人员
                    result.add("风险人员");
                }
            }
        }
        return new ArrayList<String>(result);
//        ArrayList<String> tags = new ArrayList<>();
//        tags.add("重点人员");
//        return tags;
    }
}
