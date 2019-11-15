package com.jd.popc.mapper;

import com.jd.service.shoppinginfo.domain.ShoppingInfoVo;
import com.jd.service.summary.model.AbnormalTrend;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author yangsong6
 */
public interface AbnormalInfoMapper {
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
    int insert(AbnormalInfo record);

    /**
     * 有选择性的新入一条记录
     *
     * @param record
     * @return
     */
    int insertSelective(AbnormalInfo record);

    /**
     * 根据主键选择一条记录
     *
     * @param id
     * @return
     */
    AbnormalInfo selectByPrimaryKey(Long id);

    /**
     * 根据查询用水异常处理信息
     *
     * @param abnormalInfoVo
     * @return
     */
    List<AbnormalInfo> queryByCondition(AbnormalInfoRequest abnormalInfoVo);


    /**
     * 特殊标注初始化
     * @param abnormalInfoRequest
     * @return
     */
    List<AbnormalInfo> queryByConditionForInit(AbnormalInfoRequest abnormalInfoRequest);

    /**
     * 查询已处理用水异常
     * @param abnormalInfoVo
     * @return
     */
    List<AbnormalInfo> queryAbnormalForProcessed(AbnormalInfoRequest abnormalInfoVo);

    /**
     * 查询已处理用水异常 总数
     * @param abnormalInfoVo
     * @return
     */
    Integer queryAbnormalCountForProcessed(AbnormalInfoRequest abnormalInfoVo);

    /**
     * 根据条件查询用水未处理异常信息列表
     *
     * @param abnormalInfoVo
     * @return
     */
    Integer queryCountByCondition(AbnormalInfoRequest abnormalInfoVo);

    /**
     * 根据条件查询用水未处理异常信息列表
     *
     * @param abnormalInfoVo
     * @return
     */
    List<AbnormalInfo> queryTotalSummaryList();

    /**
     * 根据条件查询用水未处理异常信息列表
     *
     * @param type
     * @return
     */
    List<AbnormalInfo> queryTotalListByType(@Param("type") String type,@Param("start") String start,@Param("end") String end);

    /**
     * 根据条件查询用水未处理异常信息列表
     *
     * @param type
     * @return
     */
    List<AbnormalInfo> queryHouseTotalListByType(@Param("type") String type,@Param("start") String start,@Param("end") String end);

    /**
     * 根据主键更新非空字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AbnormalInfo record);

    /**
     * 根据procollId更新数据
     * @param record
     * @return
     */
    int updateByProCollIdSelective (AbnormalInfo record);

    /**
     * 根据主键全量更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(AbnormalInfo record);

    /**
     * 查询近一年的异常数据数
     *
     * @return
     */
    List<Map<String, String>> queryAbnormalTrend();

    /**
     * 查询近一年的异常数据按小区排行
     *
     * @return
     */
    List<AbnormalTrend> top10();

    /**
     * 更新房屋购物次数
     * @param shoppingInfoVo
     * @return
     */
    int updateShoppingTime(ShoppingInfoVo shoppingInfoVo);

    /**
     * 根据条件查询住房异常信息列表
     *
     * @param abnormalInfoVo
     * @return
     */
    Map queryHouseCountByDate(@Param("start") String start,@Param("end") String end);

    /**
     * 根据条件查询异常信息列表
     *
     * @param start，end
     * @return
     */
    Map queryCountByDate(@Param("start") String start,@Param("end") String end);
}