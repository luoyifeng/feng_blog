package com.jd.service.communityinfo.domain;

import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yangsong6
 */
@Data
public class OfficerInfo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("警员名称")
    private String officerName;

    @ApiModelProperty("警号")
    private String officerNo;

    @ApiModelProperty("警员联系方式")
    private String officerPhone;

    @ApiModelProperty("所属单位")
    private String officerStation;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态: 1 禁用; 0 启用")
    private Byte status;

    @ApiModelProperty("删除标志位: 1 已删除; 0 正常")
    private Byte deleted;

    @ApiModelProperty("角色: officer, admin")
    private String role;

    @ApiModelProperty("权限菜单")
    private String menuIds;

    @ApiModelProperty("创建时间")
    private Date createTime;

    public OfficerInfo(){

    }

    public OfficerInfo(CommunityOfficerResponse communityOfficerResponse){
        this.id = communityOfficerResponse.getId();
        this.officerName = communityOfficerResponse.getOfficerName();
        this.officerNo = communityOfficerResponse.getOfficerNo();
        this.officerPhone = communityOfficerResponse.getOfficerPhone();
    }

}