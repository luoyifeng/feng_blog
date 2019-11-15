package com.jd.popc.controller;

import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.CommunityOfficerAnno;
import com.jd.service.communityinfo.domain.CommunityInfo;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.*;
import com.jd.service.communityinfo.service.CommunityOfficerService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 小区警员维护
 *
 * @author yangsong on 2018/11/29.
 */
@Api(tags = "小区信息管理", description = "CommunityOfficerController")
@RestController
@Slf4j
@CommunityOfficerAnno
@RequestMapping("/community/officer")
public class CommunityOfficerController extends BaseController {

    @Autowired
    private CommunityOfficerService communityOfficerService;

    @Value("${local.community.file.upload.path}")
    private String localPath;

    @ApiOperation(value = "根据条件获取小区警员信息列表", notes = "根据条件获取小区警员信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据条件获取小区警员信息列表成功")
    })
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<CommunityOfficerResponse>> queryByCondition(@ModelAttribute CommunityOfficerRequest request) {
        Integer currentPage = request.getCurrentPage();
        if (currentPage == null) {
            currentPage = 1;
        }
        request.setCurrentPage(currentPage);

        Integer totalSize = communityOfficerService.queryCountByCondition(request);
        log.info("community officer currentPage:{}, {}", currentPage, totalSize);

        List<CommunityOfficerResponse> communityOfficerInfo = communityOfficerService.queryByCondition(request);

        return ServiceResponse.successWithPageInfo(communityOfficerInfo, currentPage, totalSize);
    }

    @ApiOperation(value = "根据小区ID获取小区警员信息列表", notes = "根据条件获取小区警员信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据小区ID获取小区警员信息列表成功")
    })
    @GetMapping("/queryByOfficeInfoByCommunityId")
    public ServiceResponse<List<OfficerVo>> queryByOfficeInfoByCommunityId(@RequestParam("id") int id) {
        return ServiceResponse.success(communityOfficerService.queryOfficeInfoByCommunityId(id));
    }


    @ApiOperation(value = "根据小区名称查询小区信息列表", notes = "根据小区名称查询小区信息列表")
    @ApiImplicitParam(name = "communityName", value = "小区名称", required = true, dataType = "String", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据小区名称查询小区信息列表成功")
    })
    @GetMapping("/queryCommunityByName")
    public ServiceResponse<List<CommunityInfo>> queryCommunityByName(@RequestParam("communityName") String communityName) {
        return ServiceResponse.success(communityOfficerService.queryCommunityByName(communityName));
    }

    @ApiOperation(value = "根据警号或警员姓名查询警员信息列表", notes = "根据警号或警员姓名查询警员信息列表")
    @ApiImplicitParam(name = "officerName", value = "警号或警员姓名", required = true, dataType = "String", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据警号或警员姓名查询警员信息列表成功")
    })
    @GetMapping("/queryOfficerByName")
    public ServiceResponse<List<OfficerInfo>> queryOfficerByName(@RequestParam("officerName") String officerName) {
        return ServiceResponse.success(communityOfficerService.queryOfficerByName(officerName));
    }

    @ApiOperation(value = "获取所有小区列表", notes = "获取所有小区列表")
    @GetMapping("/queryAllCommunity")
    public ServiceResponse<List<String>> queryAllCommunity() {
        List<CommunityInfo> communityInfos = communityOfficerService.queryCommunityByName(null);
        return ServiceResponse.success(communityInfos.stream().map(CommunityInfo::getCommunityName).collect(Collectors.toList()));
    }

    @ApiOperation(value = "解除小区和警员之间的维护关系", notes = "解除小区和警员之间的维护关系")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "解除小区和警员之间的维护关系成功")
    })
    @PostMapping("/detachCommunityOfficerRelation")
    public ServiceResponse<Integer> detachCommunityOfficerRelation(@RequestBody CommunityOfficerRelation relation) {
        if (relation == null && relation.getOfficerIds() != null && relation.getCommunityId() != null) {
            return ServiceResponse.failure();
        }
        return ServiceResponse.success(communityOfficerService.detachCommunityOfficerRelation(relation));
    }

    @ApiOperation(value = "保存小区和警员之间的维护关系", notes = "保存小区和警员之间的维护关系")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "保存小区和警员之间的维护关系成功")
    })
    @GetMapping("/saveCommunityOfficerRelation")
    public ServiceResponse<Integer> saveCommunityOfficerRelation(@ModelAttribute CommunityOfficerRelation relation) {
        if (relation == null || relation.getCommunityId() == null) {
            return ServiceResponse.failure();
        }
        return ServiceResponse.success(communityOfficerService.saveCommunityOfficerRelation(relation));
    }


    @ApiOperation(value = "基于主键更新小区信息", notes = "基于主键更新小区信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "更新小区信息成功")
    })
    @GetMapping("/updateCommunityInfo")
    public ServiceResponse<Integer> updateCommunityInfo(@ModelAttribute CommunityInfo relation) {
        if (relation == null || relation.getId() == null) {
            return ServiceResponse.failure();
        }
        return ServiceResponse.success(communityOfficerService.updateByPrimaryKeySelective(relation));
    }


    @ApiOperation(value = "保存新小区和警员之间的维护关系", notes = "保存新小区和警员之间的维护关系")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "保存新小区和警员之间的维护关系")
    })
    @PostMapping("/saveNewCommunityWithOfficerRelation")
    public ServiceResponse<Integer> saveCommunityOfficerRelation(@RequestBody CommunityInfo relation) {

        int communityId = communityOfficerService.insertNewCommunity(relation);
        CommunityOfficerRelation communityOfficerRelation = new CommunityOfficerRelation();
        for (OfficerInfo officerInfo : relation.getOfficerInfos()) {
            if (communityOfficerRelation.getOfficerIds() == null) {
                communityOfficerRelation.setOfficerIds(new ArrayList<>());
            }
            communityOfficerRelation.getOfficerIds().add(officerInfo.getId());
        }
        communityOfficerRelation.setCommunityId(communityId);
        log.info("add new community officer relation  communityId {} ,officerName {}", communityId, communityOfficerRelation.getOfficerIds());
        int code = communityOfficerService.saveCommunityOfficerRelation(communityOfficerRelation);

        return ServiceResponse.success(code);
    }

    @ApiOperation(value = "删除小区", notes = "删除小区")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "删除小区所有信息")
    })
    @GetMapping("/deleteCommunity")
    public ServiceResponse<Integer> deleteCommunity(@ModelAttribute NewCommunityOfficerRelation relation) {
        if (relation.getCommunityId() == 0) {
            return ServiceResponse.failure();
        }
        int id = communityOfficerService.deleteCommunityOfficerRelationByCommunityId(relation.getCommunityId());
        int id2 = communityOfficerService.deleteCommunityInfoByPrimaryKey(relation.getCommunityId());

        log.info("delete community info with Relation {} , Community {}", id, id2);

        return ServiceResponse.success(id2);
    }


    @RequestMapping(path = "/uploadCommunityInfo")
    @ResponseBody
    public ServiceResponse<String> uploadWaterInfoFile(@RequestParam("file") MultipartFile file) throws Exception {
//        File localFile = new File(String.format("%s_%s", sdf.format(new Date()), file.getOriginalFilename()));
//        File saveFile = new File(localPath + "/water/" + localFile);
        log.debug("[CommunityOfficerController] upload file name {} ", file.getOriginalFilename());
        File localFile = new File(String.format("%s", file.getOriginalFilename()));
        File saveFile = new File(localPath + localFile);
        FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
        return new ServiceResponse<>(saveFile.getCanonicalPath());
    }


    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime() + "——" + "章");
    }
}
