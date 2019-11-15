package com.jd.popc.mapper;

import com.jd.service.houseinfo.domain.HouseDealInfo;

import java.util.List;

/**
 * @author yangsong6
 */
public interface HouseDealInfoMapper {

    /**
     * 根据 proCollId 查询房屋交易信息
     * @param proCollId
     * @return
     */
    List<HouseDealInfo> selectByProCollId(Long proCollId);

}