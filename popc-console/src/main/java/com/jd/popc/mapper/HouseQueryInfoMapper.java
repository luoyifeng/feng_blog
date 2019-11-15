package com.jd.popc.mapper;

import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.houseinfo.model.HouseQueryRequest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author yangsong6
 */
public interface HouseQueryInfoMapper {

    /**
     * 根据条件查询房屋列表信息
     *
     * @param houseQueryRequest
     * @return
     */
    List<HouseQueryInfo> queryByCondition(HouseQueryRequest houseQueryRequest);

    /**
     * 根据条件查询列表信息
     *
     * @param houseQueryRequest
     * @return
     */
    Integer queryCountByCondition(HouseQueryRequest houseQueryRequest);

    /**
     * 查询房屋构成，按房屋状态
     *
     * @return
     */
    List<Map<String, Object>> queryHouseCompose();

    /**
     * 各小区房屋明细，按房屋状态
     *
     * @return
     */
    List<Map<String, Object>> queryHouseComposeByCommunity();

    /**
     * 更新明细
     * @param houseQueryInfo
     * @return
     */
    int updateByPrimaryKeySelective(HouseQueryInfo houseQueryInfo);

    /**
     * 根据procollId更新数据
     * @param houseQueryInfo
     * @return
     */
    int updateByProCollIdSelective (HouseQueryInfo houseQueryInfo);

    /**
     * 房屋状态统计
     * @param communityName
     * @param apartmentNum
     * @return
     */
    Map<String, Object> queryHouseComposeBy(@Param("communityName") String communityName,@Param("apartmentNum") String apartmentNum);

    List<HouseQueryInfo> queryHouseListByTypeAndC(@Param("type") String type,@Param("communityName") String communityName,@Param("apartmentNum") String apartmentNum);
}