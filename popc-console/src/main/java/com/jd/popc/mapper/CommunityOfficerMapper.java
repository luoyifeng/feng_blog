package com.jd.popc.mapper;

import com.jd.service.communityinfo.domain.CommunityInfo;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRelation;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.communityinfo.model.OfficerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yangsong6
 */
public interface CommunityOfficerMapper {

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
     * 根据小区名字查询小区信息
     *
     * @param communityName
     * @return
     */
    List<CommunityInfo> queryCommunityByName(@Param("communityName") String communityName);

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
    int detachCommunityOfficerRelation(@Param("relation") CommunityOfficerRelation relation);

    /**
     * 保存小区和警员之间的关联关系
     *
     * @param relation
     * @return
     */
    int saveCommunityOfficerRelation(@Param("relation") CommunityOfficerRelation relation);

    /**
     * 查询所有小区下对应的警员列表
     *
     * @return
     */
    List<Map<String, String>> queryOfficerGroupByCommunity();

    /**
     * 添加新小区
     *
     * @return
     */
    int insert(CommunityInfo info);


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


    /**
     * 根据主键 更新小区信息
     * @param info
     * @return
     */
    int updateByPrimaryKeySelective(CommunityInfo info);

    /**
     * 根据小区ID查询警员信息
     * @param id
     * @return
     */
    List<OfficerVo> queryOfficeInfoByCommunityId(@Param("id") int id);
}