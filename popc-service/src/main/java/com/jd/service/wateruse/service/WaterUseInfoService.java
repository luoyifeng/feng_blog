package com.jd.service.wateruse.service;

import com.jd.com.base.response.ServiceResponse;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.model.ArrayParam;
import com.jd.service.wateruse.model.TrendVue;
import com.jd.service.wateruse.model.WaterUseInfoRequest;

import java.util.List;

/**
 * @author yangsong on 2018/11/30.
 */
public interface WaterUseInfoService {

    /**
     * 查询用水异常信息列表
     *
     * @param request
     * @return
     */
    ServiceResponse<List<WaterUseInfo>> queryWaterUseInfos(WaterUseInfoRequest request);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(WaterUseInfo record);

    /**
     * 判定用水异常
     *
     * @param arrayParam
     * @return
     */
    boolean judgeAbnormal(ArrayParam arrayParam);

    /**
     * 查询近一年用水量
     *
     * @param proCollId
     * @return
     */
    TrendVue queryWaterTrendByProCollId(Long proCollId);

    /**
     * 自动化执行异常用水数据处理
     */
    void autoJudgeAbnormal();
}
