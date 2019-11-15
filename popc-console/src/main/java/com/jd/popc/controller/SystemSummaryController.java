package com.jd.popc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jd.com.base.response.ServiceResponse;
import com.jd.common.utils.NumberUtil;
import com.jd.popc.annotation.SystemSummaryAnno;
import com.jd.popc.service.summary.view.HouseSummaryDownloadView;
import com.jd.popc.service.summary.view.PieSummaryDownloadView;
import com.jd.popc.service.summary.view.TotalSummaryDownloadView;
import com.jd.popc.service.wateruse.view.WaterUseInfoDownloadView;
import com.jd.service.summary.model.HouseDetails;
import com.jd.service.summary.model.MapCount;
import com.jd.service.summary.model.PieDetails;
import com.jd.service.summary.model.TotalSummary;
import com.jd.service.summary.model.TotalSummaryRequest;
import com.jd.service.summary.service.SystemSummaryService;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;
import com.jd.service.surveyvisit.service.AbnormalInfoService;
import com.jd.service.wateruse.model.TrendVue;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yangsong on 2019/2/27.
 */
@Api(tags = "系统概览", description = "SystemSummaryController")
@SystemSummaryAnno
@RestController
@Slf4j
@RequestMapping("/system/summary")
public class SystemSummaryController {

    @Autowired
    private SystemSummaryService summaryService;
    
    @GetMapping("/total")
    public ServiceResponse<List<TotalSummary>> totalSummary() {
        return ServiceResponse.success(summaryService.totalSummary());
    }
    @GetMapping("/card/total")
    public ServiceResponse<List<TotalSummary>> cardTotalSummary(@RequestParam("start") String start, @RequestParam("end") String end) {
        
    	return ServiceResponse.success(summaryService.totalSummary(start,end));
    }
    
    @GetMapping("/card/totalList")
    public ServiceResponse<TotalSummary> queryByCondition(@RequestParam("type") String type, @RequestParam("start") String start, @RequestParam("end") String end) {
        return ServiceResponse.success(summaryService.totalList(type,start,end));
    }
    
    @GetMapping("/house/total")
    public ServiceResponse<List<TotalSummary>> houseTotalSummary(@RequestParam("start") String start, @RequestParam("end") String end) {
        return ServiceResponse.success(summaryService.houseTotalSummary(start,end));
    }
    
    @GetMapping("/pie/total")
    public ServiceResponse<List<TotalSummary>> pieTotalSummary(@RequestParam("start") String start, @RequestParam("end") String end) {
        return ServiceResponse.success(summaryService.pieTotalSummary(start,end));
    }
    
    @GetMapping("/houseCompose")
    public ServiceResponse<TrendVue> houseCompose() {
        return ServiceResponse.success(summaryService.houseCompose());
    }
    
    @GetMapping("/pieCompose")
    public ServiceResponse<TrendVue> pieCompose() {
        return ServiceResponse.success(summaryService.pieCompose());
    }

    @GetMapping("/houseDetails")
    public ServiceResponse<List<HouseDetails>> houseDetails() {
        return ServiceResponse.success(summaryService.houseDetails());
    }

    @GetMapping("/pieDetails")
    public ServiceResponse<List<PieDetails>> pieDetails() {
        return ServiceResponse.success(summaryService.pieDetails());
    }
    
    @GetMapping("/abnormalTrend")
    public ServiceResponse<TrendVue> abornalTrend() {
        return ServiceResponse.success(summaryService.abnormalTrend());
    }

    @GetMapping("top10")
    public ServiceResponse top10() {
        return ServiceResponse.success(summaryService.top10());
    }
    
    @GetMapping("/download")
    public ModelAndView download(@RequestParam("start") String start, @RequestParam("end") String end) {
    	TotalSummaryRequest request=new TotalSummaryRequest();
    	request.setStart(start);
    	request.setEnd(end);
    	Map<String, Object> model = new HashMap<>(2);
        model.put("serviceBean", summaryService);
        model.put("requestParam", request);
        return new ModelAndView(new TotalSummaryDownloadView(), model);
    }
    
    @GetMapping("/house/download")
    public ModelAndView house_download() {
    	TotalSummaryRequest request=new TotalSummaryRequest();
    	request.setHouseList(summaryService.houseDetails());
    	Map<String, Object> model = new HashMap<>(2);
        model.put("serviceBean", summaryService);
        model.put("requestParam", request);
        return new ModelAndView(new HouseSummaryDownloadView(), model);
    }
    
    @GetMapping("/pie/download")
    public ModelAndView pie_download() {
    	TotalSummaryRequest request=new TotalSummaryRequest();
    	request.setPieList(summaryService.pieDetails());
    	Map<String, Object> model = new HashMap<>(2);
        model.put("serviceBean", summaryService);
        model.put("requestParam", request);
        return new ModelAndView(new PieSummaryDownloadView(), model);
    }
    
    /**
             * 地图展示统计
     * @return
     */
    @GetMapping("/mapCount")
    public ServiceResponse<MapCount> mapCount(@RequestParam("communityName") String communityName, @RequestParam("apartmentNum") String apartmentNum) {
        return ServiceResponse.success(summaryService.mapCount(communityName,apartmentNum));
    }
    
    @GetMapping("/mapCount/mapCountList")
    public ServiceResponse<TotalSummary> queryMapCountList(@RequestParam("type") String type, @RequestParam("communityName") String communityName, @RequestParam("apartmentNum") String apartmentNum) {
        return ServiceResponse.success(summaryService.queryMapCountList(type,communityName,apartmentNum));
    }
    
    @GetMapping("/mapCount/mapPage")
    public ModelAndView mapPage() {
        return new ModelAndView("forward:/index.html");
    }
}
