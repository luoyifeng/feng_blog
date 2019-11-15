package com.jd.service.shoppinginfo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ShoppingSocietyInfo {
    @ApiModelProperty("自增主键id")
    private Long id;

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("手机号（订）")
    private String orderPhone;

    @ApiModelProperty("姓名（寄）")
    private String senderName;

    @ApiModelProperty("手机号（收）")
    private String recipentPhone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("登记时间")
    private Date registTime;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("收货人姓名")
    private String recipentName;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("收货地址")
    private String recipentAddress;
}