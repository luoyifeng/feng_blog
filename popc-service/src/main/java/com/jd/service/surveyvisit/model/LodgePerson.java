package com.jd.service.surveyvisit.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong on 2018/12/5.
 */
@Data
public class LodgePerson {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("证件类型")
    private String certificateType;

    @ApiModelProperty("证件号码")
    private String certificateNo;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("人员类别")
    private String personCategory;

    @ApiModelProperty("户籍地址")
    private String residenceAddress;

    @ApiModelProperty("联系方式")
    private String contactInfo;
}
