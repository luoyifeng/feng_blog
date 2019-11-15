package com.jd.service.surveyvisit.domain;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 走访核实单 映射数据库字段
 * @author yangsong6
 */
@Data
public class CheckForm extends PageVo {

    @ApiModelProperty("自增主键ID")
    private Long id;

    @ApiModelProperty("app_survey_visit_abnormal_info 处理异常信息表主键ID")
    private Long abnormalInfoId;

    @ApiModelProperty("app_survey_visit_abnormal_info 处理异常信息表主键ID 集合")
    private List<Long> abnormalInfoIds;

    @ApiModelProperty("寄住人员，用分号隔开")
    private String lodgePerson;

    @ApiModelProperty("房屋出租，用分号隔开")
    private String houseRent;

    @ApiModelProperty("其他原因")
    private String otherReason;

    @ApiModelProperty("核实人员，用分号隔开")
    private String checkPerson;

    @ApiModelProperty("走访人员，用分号隔开")
    private String visitPerson;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private Long proCollId;

    @ApiModelProperty("人员隐患")
    private String personDanger;

    @ApiModelProperty("人员其他隐患")
    private String personOtherDanger;

    @ApiModelProperty("房屋隐患")
    private String houseDanger;

    @ApiModelProperty("房屋其他隐患")
    private String houseOtherDanger;

    @ApiModelProperty("是否存在隐患")
    private String judgeDanger;

    @ApiModelProperty("房屋状态")
    private String houseStatus;

    @ApiModelProperty("确认核实")
    private int auditConfirm;

    @ApiModelProperty("房屋特殊标签")
    private String houseSpecialMark;

    @ApiModelProperty("小区")
    private String communityName;
}