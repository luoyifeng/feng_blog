package com.jd.service.summary.model;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 首页前端传值
 *
 * @author yangsong6
 */
@Data
public class TotalSummaryRequest extends PageVo {

    @ApiModelProperty("开始时间")
    private String start;
    
    @ApiModelProperty("结束时间")
    private String end;
    
    @ApiModelProperty("房屋列表")
    private List<HouseDetails> houseList;
    
    @ApiModelProperty("人口列表")
    private List<PieDetails> pieList;
}