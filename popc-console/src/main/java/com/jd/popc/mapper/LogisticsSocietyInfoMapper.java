package com.jd.popc.mapper;


import com.jd.service.shoppinginfo.domain.LogisticsSocietyInfo;

import java.util.List;

public interface LogisticsSocietyInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogisticsSocietyInfo record);

    int insertSelective(LogisticsSocietyInfo record);

    LogisticsSocietyInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogisticsSocietyInfo record);

    int updateByPrimaryKey(LogisticsSocietyInfo record);

    /**
     * 根据 proCollId 查询
     * @param proCollId
     * @return
     */
    List<LogisticsSocietyInfo> selectByProCollId(Long proCollId);
}