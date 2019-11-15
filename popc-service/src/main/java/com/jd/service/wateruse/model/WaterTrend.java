package com.jd.service.wateruse.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/12.
 */
@Data
public class WaterTrend {

    @ApiModelProperty("时间")
    private String date;

    @ApiModelProperty("用水量")
    private Double consumption;
}
