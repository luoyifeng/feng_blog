package com.jd.popc.mapper;

import com.jd.service.shoppinginfo.domain.ShoppingInfoVo;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.domain.WaterUseInfoException;
import com.jd.service.wateruse.model.WaterTrend;
import com.jd.service.wateruse.model.WaterUseInfoQuery;

import java.util.List;

/**
 * @author yangsong6
 */
public interface WaterUseInfoMapper {
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
    int insert(WaterUseInfo record);

    /**
     * 有选择性的非空字段插入一条记录
     *
     * @param record
     * @return
     */
    int insertSelective(WaterUseInfo record);

    /**
     * 根据主键查询一条记录
     *
     * @param id
     * @return
     */
    WaterUseInfo selectByPrimaryKey(Long id);

    /**
     * 根据条件查询用水异常信息列表
     *
     * @param query
     * @return
     */
    List<WaterUseInfo> queryByCondition(WaterUseInfoQuery query);

    /**
     * 根据条件查询用水异常信息列表
     *
     * @param query
     * @return
     */
    Integer queryCountByCondition(WaterUseInfoQuery query);

    /**
     * 当前月有无推数
     *
     * @return
     */
    WaterUseInfo hasRecordsByCurrentMonth();

    /**
     * 有选择性的更新一条记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(WaterUseInfo record);

    /**
     * 依据procollId更新记录
     * @param record
     * @return
     */
    int updateByProCollIdKeySelective(WaterUseInfo record);

    /**
     * 根据主键更新所有的字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(WaterUseInfo record);

    /**
     * 查询近一年用水量
     *
     * @param proCollId
     * @return
     */
    List<WaterTrend> queryWaterTrendByProCollId(Long proCollId);

    /**
     * 查询异常的用水数据
     * @param wie
     * @return
     */
    List<Long> queryIdsByAbnomalCondition(WaterUseInfoException wie);

    /**
     * 根据购物信息更新购物次数
     * @param shoppingInfoVo
     * @return
     */
    int updateShoppingTime(ShoppingInfoVo shoppingInfoVo);

    /**
     * 根据地址匹配查询房屋总id
     * @param shoppingInfoVo
     * @return
     */
    Long selectProCollIdByAddress(ShoppingInfoVo shoppingInfoVo);

    /**
     * 针对于定时任务获取用水信息
     * @param waterUseInfoQuery
     * @return
     */
    List<WaterUseInfo> queryWaterInfoForInit(WaterUseInfoQuery waterUseInfoQuery);

    /**
     * 针对于定时任务获取总共的用水信息数目
     * @return
     */
    int queryWaterInfoCountForInit();
}