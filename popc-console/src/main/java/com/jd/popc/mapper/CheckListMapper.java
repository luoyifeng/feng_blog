package com.jd.popc.mapper;

import com.jd.service.surveyvisit.domain.CheckForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yangsong6
 */
public interface CheckListMapper {

    /**
     * 根据主键删除一条记录
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(CheckForm record);

    /**
     * 将非空字段插入
     *
     * @param record
     * @return
     */
    int insertSelective(CheckForm record);

    /**
     * 根据主键查询一条记录
     *
     * @param id
     * @return
     */
    CheckForm selectByPrimaryKey(Long id);

    /**
     * 根据异常信息表id集合查询基本信息
     * @param checkForm
     * @return
     */
    List<CheckForm> queryByabnormalInfoIdList(CheckForm checkForm);

    /**
     * 根据 app_survey_visit_abnormal_info.id 查询最近一样走访核实信息
     *
     * @param proCollId
     * @param queryAll
     * @return
     */
    List<CheckForm> queryAllFeedbackById(@Param("proCollId") Long proCollId, @Param("queryAll") Boolean queryAll, @Param("auditConfirm") int auditConfirm);

    /**
     * 更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CheckForm record);

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(CheckForm record);

    /**
     * 查询走访核实数
     *
     * @return
     */
    Integer queryTotalVisits();

    /**
     * 根据条件查询异常信息列表
     *
     * @param type
     * @return
     */
    List<CheckForm> queryPieCountByDate(@Param("start") String start,@Param("end") String end);

    /**
     * 查询
     *
     * @return
     */
    List<CheckForm> queryPieCompose();

    /**
     * 查询
     *
     * @return
     */
    List<CheckForm> queryPieComposeBy(@Param("communityName") String communityName,@Param("apartmentNum") String apartmentNum);

    /**
     * 根据条件查询异常信息列表
     *
     * @param type
     * @return
     */
    List<CheckForm> queryPieListCountBy(@Param("type") String type,@Param("communityName") String communityName,@Param("apartmentNum") String apartmentNum);

    /**
     * 根据小区名和电话查询房屋总id
     * @param map
     * @return
     */
    List<Long> queryBycommunityNameAndPhone(Map map);
}