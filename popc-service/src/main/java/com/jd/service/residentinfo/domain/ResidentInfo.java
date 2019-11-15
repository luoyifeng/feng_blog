package com.jd.service.residentinfo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yangsong6
 */
@Data
public class ResidentInfo {

    @ApiModelProperty("自增主键id")
    private Long id;

    @ApiModelProperty("姓名")
    private String residentName;

    @ApiModelProperty("证件类型")
    private String residentIdType;

    @ApiModelProperty("证件号码")
    private String residentId;

    @ApiModelProperty("出生日期")
    private String birthDate;

    @ApiModelProperty("性别")
    private String residentSex;

    @ApiModelProperty("人员类型/户籍人口/寄住人口/")
    private String residentType;
    
    @ApiModelProperty("人员情况")
    private String specialMark;
    
    @ApiModelProperty("人员情况")
    private String residentState;

    @ApiModelProperty("户号")
    private String houseNumber;

    @ApiModelProperty("跟户主关系")
    private String relat2Landlord;

    @ApiModelProperty("户籍地址")
    private String censusRegister;

    @ApiModelProperty("联系方式")
    private String contactInfo;

    @ApiModelProperty("居住地址")
    private String habitantAddress;

    @ApiModelProperty("地址是否匹配成功 1 是 0 否")
    private Byte addressMatchStatus;

    @ApiModelProperty("产权证书")
    private String propertyRightCertificate;

    @ApiModelProperty("涉警犯罪记录")
    private String criminalInfo;

    @ApiModelProperty("单位信息")
    private String companyInfo;

    @ApiModelProperty("单位地址")
    private String companyAddress;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("指系统数据新录入数据 flag=2")
    private Byte dataFlag;

    @ApiModelProperty("总房产ID")
    private Long proCollId;
    
    
}