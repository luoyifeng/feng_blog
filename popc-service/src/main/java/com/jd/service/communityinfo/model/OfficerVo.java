package com.jd.service.communityinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong6
 */
@Data
public class OfficerVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("警员名称")
    private String officerName;

    @ApiModelProperty("警号")
    private String officerNo;

    @ApiModelProperty("所属单位")
    private String officerStation;

    @ApiModelProperty("警员联系方式")
    private String officerPhone;

    @ApiModelProperty("权限菜单")
    private String menuIds;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String password;
}