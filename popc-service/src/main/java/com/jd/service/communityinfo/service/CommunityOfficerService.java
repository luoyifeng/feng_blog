package com.jd.service.communityinfo.service;

import com.jd.service.communityinfo.domain.CommunityInfo;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRelation;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.communityinfo.model.OfficerVo;

import java.util.List;

/**
 * 小区警员维护服务层
 *
 * @author yangsong on 2018/12/7.
 */
public interface CommunityOfficerService {

    /**
     * 根据条件查询小区警员信息
     *
     * @param request
     * @return
     */
    List<CommunityOfficerResponse> queryByCondition(CommunityOfficerRequest request);

    /**
     * 根据条件查询小区警员信息
     *
     * @param request
     * @return
     */
    Integer queryCountByCondition(CommunityOfficerRequest request);


    /**
     * 根据条件返回小区警员信息
     *
     * @param
     * @return
     */
    List<OfficerVo> queryOfficeInfoByCommunityId(int id);

    /**
     * 根据小区名字查询小区信息
     *
     * @param communityName
     * @return
     */
    List<CommunityInfo> queryCommunityByName(String communityName);

    /**
     * 根据警号或警员姓名查询警员信息列表
     *
     * @param officerName
     * @return
     */
    List<OfficerInfo> queryOfficerByName(String officerName);

    /**
     * 解除小区和警员之间的关联关系
     *
     * @param relation
     * @return
     */
    int detachCommunityOfficerRelation(CommunityOfficerRelation relation);

    /**
     * 保存小区和警员之间的关联关系
     *
     * @param relation
     * @return
     */
    int saveCommunityOfficerRelation(CommunityOfficerRelation relation);

    /**
     * 保存小区和警员之间的关联关系
     *
     * @param relation
     * @return
     */
    int saveSingleCommunityOfficerRelation(CommunityOfficerRelation relation);

    /**
     * 更新小区基于主键
     *
     * @param relation
     * @return
     */
    int updateByPrimaryKeySelective(CommunityInfo relation);

    /**
     * 保存新小区的信息
     *
     * @param relation
     * @return
     */
    int insertNewCommunity(CommunityInfo relation);


    /**
     * 通过小区ID 删除小区警员关联关系
     *
     * @return
     */
    int deleteCommunityOfficerRelationByCommunityId(int id);


    /**
     * 通过小区ID删除小区
     *
     * @return
     */
    int deleteCommunityInfoByPrimaryKey(int id);
}
