package com.jd.service.shoppinginfo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LogisticsSocietyInfo {

    @ApiModelProperty("自增主键id")
    private Long id;

    @ApiModelProperty("身份证号（寄）")
    private String senderIdNum;

    @ApiModelProperty("姓名（寄）")
    private String senderName;

    @ApiModelProperty("手机号（寄）")
    private String senderPhone;

    @ApiModelProperty("姓名（收）")
    private String recipientName;

    @ApiModelProperty("手机号（收")
    private String recipientPhone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("登记时间")
    private Date registTime;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;
}