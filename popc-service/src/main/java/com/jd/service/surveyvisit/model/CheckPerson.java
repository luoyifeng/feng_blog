package com.jd.service.surveyvisit.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/5.
 */
@Data
public class CheckPerson {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("联系方式")
    private String contactInfo;
}
