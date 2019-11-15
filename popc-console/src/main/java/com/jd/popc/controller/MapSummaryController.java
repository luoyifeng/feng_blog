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
@Api(tags = "系统概览", description = "MapSummaryController")
@SystemSummaryAnno
@RestController
@Slf4j
@RequestMapping("/map/summary")
public class MapSummaryController {

    @Autowired
    private SystemSummaryService summaryService;
    
 
}
