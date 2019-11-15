package com.jd.service.communityinfo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author guoxu3 on 2019-08-01
 */
@Data
public class NewCommunityOfficerRelation {

    @ApiModelProperty("小区ID")
    private Integer communityId;

    @ApiModelProperty("行政区划")
    private String communityRegion;

    @ApiModelProperty("街道")
    private String communityStreet;

    @ApiModelProperty("居委会")
    private String communityCommittee;

    @ApiModelProperty("小区名称")
    private String communityName;

    @ApiModelProperty("小区地址")
    private String communityAddress;

    @ApiModelProperty("警员表主键id")
    private List<Integer> officerInfos;
}
