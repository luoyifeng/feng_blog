package com.jd.service.wateruse.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:
 **/
@Data
public class WaterUseInfoException {
    @ApiModelProperty("房东信息")
    private int landlord;

    @ApiModelProperty("用水信息")
    private int currentWaterConsumption;

    @ApiModelProperty("卡分区起始日")
    private String startDate;

    @ApiModelProperty("卡分区结束日")
    private String endDate;
}
