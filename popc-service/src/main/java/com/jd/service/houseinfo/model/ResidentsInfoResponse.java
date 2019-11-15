package com.jd.service.houseinfo.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:luoyifeng
 **/
@Data
public class ResidentsInfoResponse {
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("关系")
    private String relation;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("民族")
    private String nation;

    @ApiModelProperty("公民身份证号码")
    private String idNumber;

    @ApiModelProperty("户籍地址")
    private String permanentAddress;

    @ApiModelProperty("是否流出")
    private String outflow;

    @ApiModelProperty("流出原因及详址")
    private String outflowInfo;

    @ApiModelProperty("案底情况")
    private String caseBackGround;

    @ApiModelProperty("工作单位")
    private String workPlace;

    @ApiModelProperty("职务")
    private String post;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("走访日期")
    private String visitDate;

    @ApiModelProperty("核实人员")
    private String checkPerson;

    @ApiModelProperty("核实人员电话")
    private String checkPersonPhone;

    @ApiModelProperty("走访人员")
    private String visitPerson;

    @ApiModelProperty("房屋隐患")
    private HiddenDanger hiddenDanger;

    @ApiModelProperty("调查走访原因")
    private String abnormalInfo;

    @ApiModelProperty("人员标签")
    private String peopleTags;
}
