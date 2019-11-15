package com.jd.popc.component;

import com.jd.popc.mapper.AbnormalInfoMapper;
import com.jd.popc.mapper.WaterUseInfoMapper;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.model.WaterUseInfoQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @description:
 * @author:luoyifeng
 **/
@Component
@Configuration
@EnableScheduling
@Slf4j
public class InitHouseSpecialMark {
    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private WaterUseInfoMapper waterUseInfoMapper;
    @Resource
    private CommonUtils commonUtils;
    private final int offset = 20;

//    @Scheduled(cron = "* 0 * * * ?")// 每个小时执行一次
    @Async
//    @Scheduled(initialDelay=300000, fixedRate=86400000)
    public void configureTasks() {
        // 更新用水数据的房屋特殊标签
        int waterUseCount = waterUseInfoMapper.queryWaterInfoCountForInit();
        if (waterUseCount == 0) {
            return;
        }
        int countTime = waterUseCount / offset;
        if (waterUseCount % offset != 0) {
            countTime++;
        }
        for (int i = 0; i < countTime; i++) {
            WaterUseInfoQuery waterUseInfoQuery = new WaterUseInfoQuery();
            waterUseInfoQuery.setCurrentPage(i * offset);
            waterUseInfoQuery.setOffset(offset);
            List<WaterUseInfo> waterUseInfos = waterUseInfoMapper.queryWaterInfoForInit(waterUseInfoQuery);
            if (waterUseInfos == null || waterUseInfos.isEmpty()) {
                continue;
            }
            waterUseInfos.stream().forEach(waterUseInfo -> {
                if (waterUseInfo.getProCollId() != null) {
                    List<ResidentsInfoResponse> residentsInfo = commonUtils.getResidentsInfo(waterUseInfo.getProCollId());

                    List<String> personTags = null;
                    if (residentsInfo != null && !residentsInfo.isEmpty()) {
                        personTags = commonUtils.getPersonTags(residentsInfo.stream()
                                .map(ResidentsInfoResponse::getIdNumber).distinct().collect(toList()));
                    }

                    if (updataHouseSpecialMark(personTags, waterUseInfo.getHouseSpecialMark())) {
                        WaterUseInfo waterUseInfoUpdate = new WaterUseInfo();
                        waterUseInfoUpdate.setProCollId(waterUseInfo.getProCollId());
                        if (personTags == null || personTags.isEmpty()) {
                            waterUseInfoUpdate.setHouseSpecialMark("");
                            waterUseInfoMapper.updateByProCollIdKeySelective(waterUseInfoUpdate);
                        } else {
                            String newHouseSpecialMark = StringUtils.join(personTags, ",");
                            waterUseInfoUpdate.setHouseSpecialMark(newHouseSpecialMark);
                            waterUseInfoMapper.updateByProCollIdKeySelective(waterUseInfoUpdate);
                        }
                    }
                }
            });
        }

        // 更新异常走访信息的房屋特殊标签
        AbnormalInfoRequest abnormalInfo = new AbnormalInfoRequest();
        Integer abnormalCount = abnormalInfoMapper.queryCountByCondition(abnormalInfo);
        countTime = abnormalCount / offset;
        if (abnormalCount % offset != 0) {
            countTime++;
        }
        for (int i = 0; i < countTime; i++) {
            abnormalInfo.setCurrentPage(i * offset);
            abnormalInfo.setOffset(offset);
            List<AbnormalInfo> abnormalInfos = abnormalInfoMapper.queryByConditionForInit(abnormalInfo);
            abnormalInfos.stream().forEach(abnormalInfoOne -> {
                if (abnormalInfoOne.getProCollId() != null) {
                    List<ResidentsInfoResponse> residentsInfo = commonUtils.getResidentsInfo(abnormalInfoOne.getProCollId());

                    List<String> personTags = null;
                    if (residentsInfo != null && !residentsInfo.isEmpty()) {
                        personTags = commonUtils.getPersonTags(residentsInfo.stream()
                                .map(ResidentsInfoResponse::getIdNumber).distinct().collect(toList()));
                    }

                    if (updataHouseSpecialMark(personTags, abnormalInfoOne.getHouseSpecialMark())) {
                        AbnormalInfo abnormalInfoNew = new AbnormalInfo();
                        abnormalInfoNew.setProCollId(abnormalInfoOne.getProCollId());
                        if (personTags == null || personTags.isEmpty()) {
                            abnormalInfoNew.setHouseSpecialMark("");
                            abnormalInfoMapper.updateByProCollIdSelective(abnormalInfoNew);
                        } else {
                            String newHouseSpecialMark = StringUtils.join(personTags, ",");
                            abnormalInfoNew.setHouseSpecialMark(newHouseSpecialMark);
                            abnormalInfoMapper.updateByProCollIdSelective(abnormalInfoNew);
                        }
                    }
                }
            });
        }
    }

    /**
     * 判断是否更新房屋特殊标签
     * @param personTags
     * @param oldPersonTagStr
     * @return true 为需要更新，false为不需要更新
     */
    private boolean updataHouseSpecialMark(List<String> personTags, String oldPersonTagStr) {
        if (personTags == null || personTags.isEmpty()) {
            if (StringUtils.isEmpty(oldPersonTagStr)) {
                return false;
            } else {
                return true;
            }
        } else {
            if (StringUtils.isEmpty(oldPersonTagStr)) {
                return true;
            } else {
                List<String> oldPersonTags = Arrays.asList(oldPersonTagStr.split(",",  -1));
                if (personTags.size() == oldPersonTags.size() && personTags.containsAll(oldPersonTags)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
