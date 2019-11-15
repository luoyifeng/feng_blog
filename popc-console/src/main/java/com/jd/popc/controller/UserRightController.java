package com.jd.popc.controller;

import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.UserRightAnno;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.OfficerVo;
import com.jd.service.userright.model.MenuResponse;
import com.jd.service.userright.model.OfficerRequest;
import com.jd.service.userright.service.UserRightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户权限管理
 *
 * @author yangsong on 2018/12/9.
 */
@Api(tags = "用户权限管理", description = "UserRightController")
@RestController
@Slf4j
@UserRightAnno
@RequestMapping("/user/right")
public class UserRightController extends BaseController {

    @Autowired
    private UserRightService userRightService;

    @ApiOperation(value="根据条件获取小区警员信息列表", notes="根据条件获取小区警员信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据条件获取小区警员信息列表成功")
    })
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<OfficerInfo>> queryByCondition(@ModelAttribute OfficerRequest request) {
        Integer currentPage = request.getCurrentPage();
        if(currentPage == null) {
            currentPage = 1;
        }
        request.setCurrentPage(currentPage);

        int totalSize = userRightService.queryCountByCondition(request);
        log.info("community officer list:{}, {}", currentPage, totalSize);

        return ServiceResponse.successWithPageInfo(userRightService.queryByCondition(request), currentPage, totalSize);
    }

    @ApiOperation(value="根据id修改小区警员信息", notes="根据id修改小区警员信息，比如禁用启用，删除等")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据id修改小区警员信息成功")
    })
    @GetMapping("/updateById")
    public ServiceResponse<String> updateById(@ModelAttribute OfficerRequest request) {
        return userRightService.updateById(request);
    }

    @ApiOperation(value="获取菜单资源列表以赋予用户菜单权限用", notes="获取菜单资源列表以赋予用户菜单权限用")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "获取菜单资源列表成功")
    })
    @GetMapping("/listMenuResource")
    public ServiceResponse<List<MenuResponse>> listMenuResource() {
        return ServiceResponse.success(userRightService.listMenuResource());
    }

    @ApiOperation(value="获取当前登录用户有权限的菜单列表", notes="获取当前登录用户有权限的菜单列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "获取当前登录用户有权限的菜单列表成功")
    })
    @GetMapping("/getCurrentUserMenu")
    public ServiceResponse<List<MenuResponse>> getCurrentUserMenu(@RequestParam("officerNo") String officerNo) {
//        String officerNo = getOfficerNoByCookie(request.getCookies(), "officerNo");
        if(officerNo == null) {
            return ServiceResponse.failure("登录失败");
        }

        return ServiceResponse.success(userRightService.getCurrentUserMenu(officerNo));
    }

    @ApiOperation(value="新增或修改警员信息，如果id为空表示新增否则为修改", notes="新增或修改警员信息，如果id为空表示新增否则为修改")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "新增或修改警员信息成功")
    })
    @GetMapping("/saveOfficerInfo")
    public ServiceResponse<Integer> saveOfficerInfo(@ModelAttribute OfficerVo officerVo) {
        if(officerVo == null || officerVo.getOfficerName() == null || officerVo.getOfficerNo() == null) {
            return ServiceResponse.failure();
        }

        return ServiceResponse.success(userRightService.saveOfficerInfo(officerVo));
    }

    @ApiOperation(value="重置密码", notes="重置密码")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "重置密码成功")
    })
    @GetMapping("/resetPassword")
    public ServiceResponse<Integer> resetPassword(@RequestParam("id") String id) {
        if(id == null) {
            return ServiceResponse.failure();
        }

        return ServiceResponse.success(userRightService.resetPassword(id));
    }

    @ApiOperation(value="根据警号查询警员信息", notes="根据警号查询警员信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据警号查询警员信息成功")
    })
    @GetMapping("/selectByOfficerNo")
    public ServiceResponse<OfficerInfo> selectByOfficerNo(HttpServletRequest request, @RequestParam("officerNo") String officerNo) {
        officerNo = StringUtils.trimToNull(officerNo);
        if(officerNo == null) {
            return ServiceResponse.failure("输入警号或密码错误");
        }

        OfficerInfo officerInfo = userRightService.selectByOfficerNo(officerNo);
        if(officerInfo == null) {
            return ServiceResponse.failure("输入警号或密码错误");
        }

        //登录成功后将用户信息放入session
        request.getSession().setAttribute("officerInfo", officerInfo);

        return ServiceResponse.success(officerInfo);
    }

    @ApiOperation(value="根据警号修改密码", notes="根据警号修改密码")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据警号修改密码成功")
    })
    @GetMapping("/updatePasswordByOfficerNo")
    public ServiceResponse<Integer> updatePasswordByOfficerNo(@RequestParam("officerNo") String officerNo,
            @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd) {
        officerNo = StringUtils.trimToNull(officerNo);
        oldPwd = StringUtils.trimToNull(oldPwd);
        newPwd = StringUtils.trimToNull(newPwd);

        if(officerNo == null || oldPwd == null || newPwd == null) {
            return ServiceResponse.failure();
        }

        Integer updateResult = userRightService.updatePasswordByOfficerNo(officerNo, oldPwd, newPwd);
        if(updateResult == null) {
            return ServiceResponse.failure();
        }

        return ServiceResponse.success(updateResult);
    }
}
