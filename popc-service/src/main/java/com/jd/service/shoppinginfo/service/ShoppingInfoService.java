package com.jd.service.shoppinginfo.service;

import com.jd.com.base.response.ServiceResponse;
import com.jd.service.shoppinginfo.domain.LogisticsSocietyInfo;
import com.jd.service.shoppinginfo.domain.ShoppingInfo;
import com.jd.service.shoppinginfo.domain.ShoppingSocietyInfo;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @description: 购物
 * @author:luoyifeng
 **/
public interface ShoppingInfoService {
    /**
     * 购物文件上传
     * @param file
     * @return
     */
    ServiceResponse uploadShoppingFile(InputStream file);

    /**
     * 根据房产总ID查询购物信息
     * @param proCollId
     * @return
     */
    List<ShoppingInfo> getShoppingInfoByProCollId(Long proCollId);

    /**
     * 根据房产总ID查询社采信息-1
     * @param proCollId
     * @return
     */
    List<ShoppingSocietyInfo> getShoppingSocietyInfoByProCollId(Long proCollId);

    /**
     * 根据房产总ID查询社采信息-2
     * @param proCollId
     * @return
     */
    List<LogisticsSocietyInfo> getLogisticsSocietyInfoByProCollId(Long proCollId);
}
