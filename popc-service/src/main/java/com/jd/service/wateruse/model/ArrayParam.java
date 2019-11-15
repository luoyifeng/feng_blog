package com.jd.service.wateruse.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yangsong on 2018/12/12.
 */
@Data
public class ArrayParam {

    @ApiModelProperty("判定异常时传递的ID列表")
    private List<Long> ids;

    @ApiModelProperty("警员警号")
    private String officerNo;

    @ApiModelProperty("判定原因")
    private String abnormalInfo;

}
