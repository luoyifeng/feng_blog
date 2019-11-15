package com.jd.service.shoppinginfo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShoppingInfo {
    @ApiModelProperty("自增主键id")
    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("京东账号")
    private String userAccount;

    @ApiModelProperty("下单时间")
    private Date orderTime;

    @ApiModelProperty("下单ip")
    private String orderIp;

    @ApiModelProperty("订单类别")
    private String orderPort;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("收货人姓名")
    private String receiverName;

    @ApiModelProperty("收货人电话")
    private String receiverPhone;

    @ApiModelProperty("收货人地址")
    private String receiverAddress;

    @ApiModelProperty("运单ID")
    private String deliverId;

    @ApiModelProperty("物流单位")
    private String expName;

    @ApiModelProperty("省")
    private String provinceName;

    @ApiModelProperty("市")
    private String cityName;

    @ApiModelProperty("县")
    private String countyName;
}