package com.jd.service.userright.service;

import com.jd.com.base.response.ServiceResponse;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.OfficerVo;
import com.jd.service.userright.model.MenuResponse;
import com.jd.service.userright.model.OfficerRequest;

import java.util.List;

/**
 * @author yangsong on 2018/12/9.
 */
public interface UserRightService {

    /**
     * 根据条件查询警员信息
     *
     * @param officerRequest
     * @return
     */
    List<OfficerInfo> queryByCondition(OfficerRequest officerRequest);

    /**
     * 根据条件查询警员信息
     *
     * @param officerRequest
     * @return
     */
    Integer queryCountByCondition(OfficerRequest officerRequest);

    /**
     * 根据主键修改警员信息
     *
     * @param officerRequest
     * @return
     */
    ServiceResponse<String> updateById(OfficerRequest officerRequest);

    /**
     * 获取菜单资源列表以赋予用户菜单权限用
     *
     * @return
     */
    List<MenuResponse> listMenuResource();

    /**
     * 获取菜单资源列表以赋予用户菜单权限用
     *
     * @param officerNo
     * @return
     */
    List<MenuResponse> getCurrentUserMenu(String officerNo);

    /**
     * 保存警员权限等信息
     *
     * @param officerVo
     * @return
     */
    int saveOfficerInfo(OfficerVo officerVo);

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    int resetPassword(String id);

    /**
     * 修改密码
     *
     * @param officerNo
     * @param oldPwd
     * @param newPwd
     * @return
     */
    Integer updatePasswordByOfficerNo(String officerNo, String oldPwd, String newPwd);

    /**
     * 根据警号查询警员信息
     *
     * @param officerNo
     * @return
     */
    OfficerInfo selectByOfficerNo(String officerNo);
}
