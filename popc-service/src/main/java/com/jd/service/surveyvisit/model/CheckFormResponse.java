package com.jd.service.surveyvisit.model;

import com.jd.service.houseinfo.model.HiddenDanger;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 走访核实单
 * @author yangsong on 2018/12/5.
 */
@Data
public class CheckFormResponse {

    @ApiModelProperty("处理异常信息列表ID，关联走访核实单使用")
    private Long abnormalInfoId;

    @ApiModelProperty("房屋信息")
    private String houseInfo;

    @ApiModelProperty("房屋状态")
    private String houseStatus;

    @ApiModelProperty("房主信息")
    private String houseLandlordInfo;

    @ApiModelProperty("入住人员信息  旧")
    private String houseResidentInfo;

    @ApiModelProperty("人员标签集合")
    private List<String> personTags;

    @ApiModelProperty("走访类型")
    private String abnormalType;

    @ApiModelProperty("走访原因")
    private String visitReason;

    @ApiModelProperty("核实结果")
    private CheckResult checkResult;

    @ApiModelProperty("核实人员")
    private List<CheckPerson> checkPersons;

    @ApiModelProperty("走访人员")
    private List<String> visitPersons;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("入住人员信息 新")
    private List<ResidentsInfoResponse> residentsInfo;

    @ApiModelProperty("房屋隐患 展示")
    private HiddenDanger hiddenDanger;

    @ApiModelProperty("审核确认")
    private int auditConfirm;
}
