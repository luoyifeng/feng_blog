package com.jd.service.communityinfo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/8.
 */
@Data
public class CommunityOfficerResponse {

//    @ApiModelProperty("webTree使用")
//    private Boolean isChildren = true;

//    @ApiModelProperty("webTree使用")
//    private Integer treeId;

    @ApiModelProperty("小区ID")
    private Integer communityId;

    @ApiModelProperty("警员表主键id")
    private Integer id;

    @ApiModelProperty("行政区划")
    private String communityRegion;

    @ApiModelProperty("街道")
    private String communityStreet;

    @ApiModelProperty("居委会")
    private String communityCommittee;

    @ApiModelProperty("小区名字")
    private String communityName;

    @ApiModelProperty("小区户数")
    private Integer communityNum;

    @ApiModelProperty("警员姓名")
    private String officerName;

    @ApiModelProperty("警号")
    private String officerNo;

    @ApiModelProperty("警员联系方式")
    private String officerPhone;

    public CommunityOfficerResponse() {

    }

    public CommunityOfficerResponse(CommunityOfficerResponse o) {
        this.communityId = o.communityId;
        this.id = o.id;
        this.communityRegion = o.communityRegion;
        this.communityStreet = o.communityStreet;
        this.communityCommittee = o.communityCommittee;
        this.communityName = o.communityName;
        this.communityNum = o.communityNum;
        this.officerName = o.officerName;
        this.officerNo = o.officerNo;
        this.officerPhone = o.officerPhone;
    }

//    public List<CommunityOfficerResponse> getChildren() {
//        if (children == null){
//            children =  new ArrayList<>();
//            CommunityOfficerResponse  communityOfficerResponse = new CommunityOfficerResponse();
//            communityOfficerResponse.officerName= "test1";
//            communityOfficerResponse.officerNo = "111112313";
//            communityOfficerResponse.officerPhone = "110";
//            children.add(communityOfficerResponse);
//        }
//
//        return children;
//    }
}
