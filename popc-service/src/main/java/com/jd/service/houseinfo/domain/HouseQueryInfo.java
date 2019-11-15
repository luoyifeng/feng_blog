package com.jd.service.houseinfo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 房屋信息查询表
 * @author yangsong6
 */
@Data
public class HouseQueryInfo {

    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("小区名称")
    private String communityName;

    @ApiModelProperty("区域")
    private String communityDistrict;

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

    @ApiModelProperty("产权证号")
    private String propertyRightCertificateNumber;
    
    private String houseDanger;
    
    private String houseSpecialMark;

}