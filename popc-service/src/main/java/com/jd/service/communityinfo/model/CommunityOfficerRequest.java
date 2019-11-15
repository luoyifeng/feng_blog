package com.jd.service.communityinfo.model;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/8.
 */
@Data
public class CommunityOfficerRequest extends PageVo {

    @ApiModelProperty("负责警员")
    private String officerName;

    @ApiModelProperty("警员编号")
    private String officerNo;

    @ApiModelProperty("小区名称")
    private String communityName;

}
