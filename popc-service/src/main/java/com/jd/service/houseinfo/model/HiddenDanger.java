package com.jd.service.houseinfo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:luoyifeng
 **/
@Data
public class HiddenDanger {
    @ApiModelProperty("房屋危险隐患 页面展示")
    private String houseDanger;
    @ApiModelProperty("人员危险隐患 页面展示")
    private String personDanger;

    @ApiModelProperty("是否存在房屋隐患")
    private String judgeDanger;

    @ApiModelProperty("人员隐患")
    private String personDangerOrig;

    @ApiModelProperty("人员其他隐患")
    private String personOtherDanger;

    @ApiModelProperty("房屋隐患")
    private String houseDangerOrig;

    @ApiModelProperty("房屋其他隐患")
    private String houseOtherDanger;
}
