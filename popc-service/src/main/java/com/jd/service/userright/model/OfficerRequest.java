package com.jd.service.userright.model;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/9.
 */
@Data
public class OfficerRequest extends PageVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("警员名称")
    private String officerName;

    @ApiModelProperty("警号")
    private String officerNo;

    @ApiModelProperty("状态: 1 禁用; 0 启用")
    private Byte status;

    @ApiModelProperty("删除标志位: 1 已删除; 0 正常")
    private Byte deleted;

    @ApiModelProperty("所属单位")
    private String officerStation;
}
