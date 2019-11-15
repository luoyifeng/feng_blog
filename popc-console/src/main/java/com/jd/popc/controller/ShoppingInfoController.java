package com.jd.popc.controller;

/**
 * @description:
 * @author:luoyifeng
 **/

import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.ShoppingInfoAnno;
import com.jd.popc.annotation.WaterUseInfoAnno;
import com.jd.service.shoppinginfo.domain.LogisticsSocietyInfo;
import com.jd.service.shoppinginfo.domain.ShoppingInfo;
import com.jd.service.shoppinginfo.domain.ShoppingSocietyInfo;
import com.jd.service.shoppinginfo.service.ShoppingInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoyifeng1 on 2018/11/29.
 */
@Api(tags = "购物信息", description = "ShoppingInfoController")
@RestController
@ShoppingInfoAnno
@Slf4j
@RequestMapping("/shopping/info")
public class ShoppingInfoController {
    @Autowired
    private ShoppingInfoService shoppingInfoService;
    @GetMapping("getShoppingInfoByProCollId")
    public ServiceResponse<Map> getShoppingInfoByProCollId(@RequestParam(value = "proCollId", required = false) Long proCollId) {
        if (proCollId == null) {
            return ServiceResponse.failure("服务出错，请重试");
        }
        List<ShoppingSocietyInfo> shoppingSocietyInfos = shoppingInfoService.getShoppingSocietyInfoByProCollId(proCollId);
        List<LogisticsSocietyInfo> logisticsSocietyInfos = shoppingInfoService.getLogisticsSocietyInfoByProCollId(proCollId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("shoppingSocietyInfos", shoppingSocietyInfos);
        resultMap.put("logisticsSocietyInfos", logisticsSocietyInfos);
        return ServiceResponse.success(resultMap);
    }
}
