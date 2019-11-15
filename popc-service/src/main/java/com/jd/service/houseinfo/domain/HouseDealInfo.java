package com.jd.service.houseinfo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 房屋交易信息表
 * @author yangsong6
 */
@Data
public class HouseDealInfo {

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

    @ApiModelProperty("产权证发证日期")
    private String propertyIssueDate;

    @ApiModelProperty("买房人姓名")
    private String landlordName;

    @ApiModelProperty("买房人身份证")
    private String landlordId;

    @ApiModelProperty("产权证书")
    private String propertyRightCertificateNumber;
}