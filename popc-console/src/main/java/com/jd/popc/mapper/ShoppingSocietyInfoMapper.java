package com.jd.popc.mapper;


import com.jd.service.shoppinginfo.domain.ShoppingSocietyInfo;

import java.util.List;

public interface ShoppingSocietyInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSocietyInfo record);

    int insertSelective(ShoppingSocietyInfo record);

    ShoppingSocietyInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingSocietyInfo record);

    int updateByPrimaryKey(ShoppingSocietyInfo record);
    /**
     * 根据 proCollId 查询
     * @param proCollId
     * @return
     */
    List<ShoppingSocietyInfo> selectByProCollId(Long proCollId);

    /**
     * 统计购物次数
     * @param record
     * @return
     */
    Long selectShoppingTimesByProCollId (ShoppingSocietyInfo record);
}