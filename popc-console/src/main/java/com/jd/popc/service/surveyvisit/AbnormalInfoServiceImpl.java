package com.jd.popc.service.surveyvisit;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.common.constant.PopcConstant;
import com.jd.common.utils.JsonUtil;
import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.AbnormalInfoMapper;
import com.jd.popc.mapper.CheckListMapper;
import com.jd.popc.mapper.CommunityOfficerMapper;
import com.jd.popc.mapper.UserRightMapper;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;
import com.jd.service.surveyvisit.service.AbnormalInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangsong on 2018/12/5.
 */
@Service
@Slf4j
public class AbnormalInfoServiceImpl implements AbnormalInfoService {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private CheckListMapper checkListMapper;
    @Resource
    private UserRightMapper userRightMapper;
    @Resource
    private CommunityOfficerMapper communityOfficerMapper;
    @Resource
    private CommonUtils commonUtils;

    @Override
    public ServiceResponse<List<AbnormalInfo>> queryAbnormalInfos(AbnormalInfoRequest abnormalInfoVo) {
        String officerNo = abnormalInfoVo.getOfficerNo();
        if(StringUtils.isEmpty(officerNo)) {
            log.error("abnormal info query -- officerNo is empty");
            return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
        }

        OfficerInfo officerInfo = userRightMapper.selectByOfficerNo(officerNo);
        if(officerInfo == null || officerInfo.getId() == null) {
            log.error("abnormal info -- officerNo is not exist");
            return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
        }

        if(!PopcConstant.Role_Admin.equalsIgnoreCase(officerInfo.getRole())) {
            CommunityOfficerRequest officerRequest = new CommunityOfficerRequest();
            officerRequest.setOfficerNo(officerNo);
            List<CommunityOfficerResponse> responseList = communityOfficerMapper.queryByCondition(officerRequest);
            if(responseList == null || responseList.size() == 0) {
                log.error("abnormal info no authority community for officerNo:{}", officerNo);
                return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
            }

            List<String> communityNames = responseList.stream().map(CommunityOfficerResponse::getCommunityName).collect(Collectors.toList());
            log.info("before filter communityNames:{}, officerNo:{}", communityNames.size(), officerNo);

            //如果用户按小区来搜，则先在有权限的小区里过滤一下
            String communityName = StringUtils.trimToNull(abnormalInfoVo.getCommunityName());
            if(communityName != null) {
                communityNames = communityNames.stream().filter(name -> name.indexOf(communityName) > -1).collect(Collectors.toList());
            }

            if(communityNames == null || communityNames.size() == 0) {
                log.error("officerNo:{}, after filtered community, no authority data!", officerNo);
                return ServiceResponse.successWithPageInfo(Lists.newArrayList(), 1, 0);
            }

            log.info("before filter communityNames:{}, officerNo:{}", communityNames.size(), officerNo);
            abnormalInfoVo.setCommunityNames(communityNames);
            abnormalInfoVo.setCommunityName(null);
        }

        Integer currentPage = abnormalInfoVo.getCurrentPage();
        if(currentPage == null) {
            currentPage = 1;
        }
        abnormalInfoVo.setCurrentPage(currentPage);

        abnormalInfoVo.setCurrentPage((abnormalInfoVo.getCurrentPage() - 1) * abnormalInfoVo.getOffset());
        log.info("abnormal info query officerNo:{}, condition:{}", officerNo, JsonUtil.toJson(abnormalInfoVo));
        List<AbnormalInfo> abnormalInfos = new ArrayList<>();
        Integer totalSize = 0;

        // 未处理异常查询
        if (abnormalInfoVo.getSolveStatus() == 1) {
            abnormalInfos = abnormalInfoMapper.queryByCondition(abnormalInfoVo);
            totalSize = abnormalInfoMapper.queryCountByCondition(abnormalInfoVo);
            log.info("survey visit currentPage:{}, {}", currentPage, totalSize);
        }

        // 已处理异常查询
        if (abnormalInfoVo.getSolveStatus() == 0) {
            abnormalInfos = abnormalInfoMapper.queryAbnormalForProcessed(abnormalInfoVo);
            totalSize = abnormalInfoMapper.queryAbnormalCountForProcessed(abnormalInfoVo);
            log.info("survey visit currentPage:{}, {}", currentPage, totalSize);
        }

        abnormalInfos = abnormalInfos.stream().map(abnormalInfo -> {
            abnormalInfo.setLandlordPhone(StringUtil.trimToEmpty(abnormalInfo.getLandlordPhone()));
            abnormalInfo.setLandlordName(StringUtil.trimToEmpty(abnormalInfo.getLandlordName()));
            abnormalInfo.setLandlordId(StringUtil.trimToEmpty(abnormalInfo.getLandlordId()));
            abnormalInfo.setLandlordName(StringUtil.trimToEmpty(abnormalInfo.getLandlordName()));
            abnormalInfo.setLandlordId(StringUtil.trimToEmpty(abnormalInfo.getLandlordId()));
            if (StringUtils.isEmpty(abnormalInfo.getRoomNum())) {
                abnormalInfo.setRoomNum("—");
            }
            return abnormalInfo;

        }).collect(Collectors.toList());

        return ServiceResponse.successWithPageInfo(abnormalInfos, currentPage, totalSize);
    }

    @Override
    public int insert(AbnormalInfo record) {
        int insertResult = abnormalInfoMapper.insert(record);
        log.info("插入一条未处理异常记录生成ID:{}，成功与否:{}", record.getId(), insertResult);
        return insertResult;
    }
}
