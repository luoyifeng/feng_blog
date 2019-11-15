package com.jd.service.houseinfo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 房屋基本信息
 *
 * @author yangsong6
 */
@Data
public class HouseBasicInfo {

    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("小区名称")
    private String communityName;

    @ApiModelProperty("区域")
    private String communityDistrict;

    @ApiModelProperty("街道")
    private String streetName;

    @ApiModelProperty("居委会")
    private String neighborhoodCommittee;

    @ApiModelProperty("楼栋名称")
    private String apartmentNum;

    @ApiModelProperty("单元")
    private String houseUnit;

    @ApiModelProperty("房(室)号")
    private String roomNum;

    @ApiModelProperty("房屋状态")
    private String houseStatus;

    @ApiModelProperty("房东姓名")
    private String landlordName;

    @ApiModelProperty("房东身份证")
    private String landlordId;

    @ApiModelProperty("联系方式")
    private String landlordPhone;

    @ApiModelProperty("产权证书")
    private String propertyRightCertificate;

    @ApiModelProperty("入住人员姓名")
    private String residentName;

    @ApiModelProperty("入住人员证件号码")
    private String residentId;

    @ApiModelProperty("入住人员性别")
    private String residentSex;

    @ApiModelProperty("入住人员出生日期")
    private String birthDate;

    @ApiModelProperty("入住人员联系方式")
    private String contactInfo;

}