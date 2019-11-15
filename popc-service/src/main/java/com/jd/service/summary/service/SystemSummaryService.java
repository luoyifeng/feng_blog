package com.jd.service.summary.service;

import java.util.Date;
import java.util.List;

import com.jd.service.summary.model.AbnormalTrend;
import com.jd.service.summary.model.HouseDetails;
import com.jd.service.summary.model.MapCount;
import com.jd.service.summary.model.PieDetails;
import com.jd.service.summary.model.TotalSummary;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.wateruse.model.TrendVue;

/**
 * @author yangsong on 2019/2/27.
 */
public interface SystemSummaryService {
    /**
     * 总体概览
     *
     * @return
     */
    List<TotalSummary> totalSummary();
    /**
     * 总体概览-new
     *
     * @return
     */
    List<TotalSummary> totalSummary(String start, String end);

    /**
     * 总体概览-list
     *
     * @return
     */
    TotalSummary totalList(String type,String start, String end);
    
    /**
     * 总体概览-住房
     *
     * @return
     */
    List<TotalSummary> houseTotalSummary(String start, String end);
    
    /**
     * 总体概览-人口
     *
     * @return
     */
    List<TotalSummary> pieTotalSummary(String start, String end);
    /**
     * 房屋构成
     *
     * @return
     */
    TrendVue houseCompose();
    
    /**
     * 人口构成
     *
     * @return
     */
    TrendVue pieCompose();

    /**
     * 小区房屋明细
     *
     * @return
     */
    List<HouseDetails> houseDetails();
    
    /**
     * 小区人口明细
     *
     * @return
     */
    List<PieDetails> pieDetails();

    /**
     * 异常数据趋势图
     *
     * @return
     */
    TrendVue abnormalTrend();

    /**
     * 小区异常排行榜 TOP10
     */
    List<AbnormalTrend> top10();
    
    /**
     * 地图展示统计
     * @param communityName
     * @param apartmentNum
     * @return
     */
    MapCount mapCount(String communityName,String apartmentNum);
    
    /**
     * 地图展示统计明细
     * @param type
     * @param communityName
     * @param apartmentNum
     * @return
     */
    TotalSummary queryMapCountList(String type,String communityName,String apartmentNum);
}
