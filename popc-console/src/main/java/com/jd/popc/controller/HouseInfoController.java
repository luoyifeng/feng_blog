package com.jd.popc.controller;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.HouseInfoAnno;
import com.jd.service.houseinfo.domain.HouseBasicInfo;
import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.houseinfo.model.HouseBasicInfoResponse;
import com.jd.service.houseinfo.model.HouseQueryRequest;
import com.jd.service.houseinfo.service.HouseInfoService;
import com.jd.service.surveyvisit.model.CheckFormResponse;
import com.jd.service.surveyvisit.service.VisitCheckService;
import com.jd.service.wateruse.model.TrendVue;
import com.jd.service.wateruse.service.WaterUseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangsong on 2018/11/29.
 */
@Api(tags = "房屋信息查询", description = "HouseInfoController")
@RestController
@HouseInfoAnno
@Slf4j
@RequestMapping("/house/info")
public class HouseInfoController extends BaseController {

    @Autowired
    private HouseInfoService houseInfoService;
    @Autowired
    private VisitCheckService visitCheckService;
    @Autowired
    private WaterUseInfoService waterUseInfoService;

    @ApiOperation(value="根据条件获取房屋信息列表", notes="根据条件获取房屋信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "房屋列表信息查询成功")
    })
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<HouseQueryInfo>> queryByCondition(@ModelAttribute HouseQueryRequest houseQueryRequest) {
        Integer currentPage = houseQueryRequest.getCurrentPage();
        if(currentPage == null) {
            currentPage = 1;
        }
        houseQueryRequest.setCurrentPage(currentPage);

        Integer totalSize = houseInfoService.queryCountByCondition(houseQueryRequest);
        log.info("query house info currentPage:{}, {}", currentPage, totalSize);

        return ServiceResponse.successWithPageInfo(houseInfoService.queryByCondition(houseQueryRequest), currentPage, totalSize);
    }

    @ApiOperation(value="根据 proCollId 查询房屋基本信息", notes="根据 proCollId 查询房屋基本信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据 proCollId 查询房屋基本信息成功")
    })
    @GetMapping("/basic")
    public ServiceResponse<HouseBasicInfoResponse> queryHouseBasicInfoByProCollId(@RequestParam(value = "proCollId", required = false)Long proCollId) {
        return ServiceResponse.success(houseInfoService.queryHouseBasicInfoByProCollId(proCollId));
    }

    @ApiOperation(value="查询该房屋所有的调查走访核实记录", notes="查询该房屋所有的调查走访核实记录")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询该房屋所有的调查走访核实记录成功")
    })
    @GetMapping("queryAllFeedbackByProCollId")
    public ServiceResponse<List<CheckFormResponse>> queryAllFeedbackById(@RequestParam(value = "proCollId", required = false) Long proCollId) {
        List<CheckFormResponse> checkFormResponse = visitCheckService.queryAllFeedbackById(proCollId, true);
        if(checkFormResponse == null) {
            return ServiceResponse.success(Lists.newArrayList());
        }

        return ServiceResponse.success(checkFormResponse);
    }

    @ApiOperation(value="房屋生活信息--近一年用水趋势图", notes="房屋生活信息--近一年用水趋势图")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询房屋生活信息--近一年用水趋势图成功")
    })
    @GetMapping("queryWaterTrendByProCollId")
    public ServiceResponse<TrendVue> queryWaterTrendByProCollId(@RequestParam(value = "proCollId", required = false) Long proCollId) {
        TrendVue trendVue = waterUseInfoService.queryWaterTrendByProCollId(proCollId);
        if(trendVue == null) {
            return ServiceResponse.failure();
        }

        return ServiceResponse.success(trendVue);
    }

    @ApiOperation(value="房屋生活信息--修改房屋基本信息", notes="房屋生活信息--修改房屋基本信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询房屋生活信息--修改房屋基本信息")
    })
    @GetMapping("saveBasicCommunity")
    public ServiceResponse<Object> saveBasicCommunity(@ModelAttribute HouseBasicInfo HouseBasicInfo) {
        Integer resultId = houseInfoService.updateHouseBasicInfo(HouseBasicInfo);
        if(resultId == null) {
            return ServiceResponse.failure();
        }

        return ServiceResponse.success(resultId);
    }
}
