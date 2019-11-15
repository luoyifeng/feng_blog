package com.jd.popc.mapper;


import com.jd.service.houseinfo.domain.HouseBasicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseBasicInfoMapper {

    /**
     * 根据 prodCollId 查询房屋基本信息
     *
     * @param proCollId
     * @return
     */
    List<HouseBasicInfo> selectByProCollId(Long proCollId);


    /**
     * 更新房屋信息
     *
     * @param houseBasicInfo
     * @return
     */
    int updateByPrimaryKeySelective(HouseBasicInfo houseBasicInfo);

    /**
     * 依据procollId更新数据
     *
     * @param houseBasicInfo
     * @return
     */
    int updateByProCollIdSelective(HouseBasicInfo houseBasicInfo);

    /**
     * 根据小区名和电话查询房屋总id
     *
     * @param map
     * @return
     */
    List<Long> queryBycommunityNameAndPhone(Map map);

    /**
     * 根据小区名字查询户数
     *
     * @param communityName
     * @return
     */
    int selectHouseCountByCommunityName(@Param("communityName") String communityName);

}