package com.jd.service.houseinfo.model;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/6.
 */
@Data
public class HouseQueryRequest extends PageVo {

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
    
    @ApiModelProperty("房屋隐患")
    private String houseDanger;
}
