package com.jd.service.communityinfo.domain;

import com.jd.service.communityinfo.model.NewCommunityOfficerRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yangsong6
 */
@Data
public class CommunityInfo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("行政区划")
    private String communityRegion;

    @ApiModelProperty("街道")
    private String communityStreet;

    @ApiModelProperty("居委会")
    private String communityCommittee;

    @ApiModelProperty("小区名")
    private String communityName;

    @ApiModelProperty("小区别名")
    private String communityAlias;

    @ApiModelProperty("小区地址")
    private String communityAddress;

    @ApiModelProperty("创建时间")
    private Date createTime;

    List<OfficerInfo> officerInfos;

    public CommunityInfo(){

    }

    public CommunityInfo(NewCommunityOfficerRelation n){
        this.communityRegion = n.getCommunityRegion();
        this.communityStreet = n.getCommunityStreet();
        this.communityCommittee = n.getCommunityCommittee();
        this.communityName = n.getCommunityName();

    }
}
