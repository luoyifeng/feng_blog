package com.jd.popc.mapper;

import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.OfficerVo;
import com.jd.service.userright.model.OfficerRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangsong on 2018/12/9.
 */
public interface UserRightMapper {

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
     * 根据主键查询警员的信息
     *
     * @param id
     * @return
     */
    OfficerInfo selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改警员信息
     *
     * @param officerRequest
     * @return
     */
    int updateById(OfficerRequest officerRequest);

    /**
     * 插入一条记录
     *
     * @param officerVo
     * @return
     */
    int insertSelective(OfficerVo officerVo);

    /**
     * 根据主键更新信息
     *
     * @param officerVo
     * @return
     */
    int updateByPrimaryKeySelective(OfficerVo officerVo);

    /**
     * 重置密码
     * @param id
     * @param pwd
     * @return
     */
    int resetPassword(@Param("id") String id, @Param("pwd") String pwd);

    /**
     * 修改密码
     *
     * @param officerNo
     * @param newPwd
     * @return
     */
    int updatePasswordByOfficerNo(@Param("officerNo") String officerNo, @Param("newPwd") String newPwd);

    /**
     * 根据警号查询警员信息
     *
     * @param officerNo
     * @return
     */
    OfficerInfo selectByOfficerNo(@Param("officerNo") String officerNo);
}
