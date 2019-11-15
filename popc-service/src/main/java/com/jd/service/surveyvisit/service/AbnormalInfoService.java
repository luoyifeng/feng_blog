package com.jd.service.surveyvisit.service;

import com.jd.com.base.response.ServiceResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;

import java.util.List;

/**
 * @author yangsong on 2018/12/5.
 */
public interface AbnormalInfoService {

    /**
     * 根据条件查询用水异常信息
     *
     * @param request
     * @return
     */
    ServiceResponse<List<AbnormalInfo>> queryAbnormalInfos(AbnormalInfoRequest request);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(AbnormalInfo record);
}
