package com.jd.service.wateruse.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用水异常数据库查询参数
 *
 * @author yangsong6
 */
@Data
public class WaterUseInfoQuery extends WaterUseInfoRequest {

    @ApiModelProperty("卡分区起始日")
    private String startDate;

    @ApiModelProperty("卡分区结束日")
    private String endDate;

    @ApiModelProperty("小区名称")
    private List<String> communityNames;
}