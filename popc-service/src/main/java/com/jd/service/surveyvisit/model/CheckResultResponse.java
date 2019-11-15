package com.jd.service.surveyvisit.model;

import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author:luoyifeng
 **/
@Data
public class CheckResultResponse {

    @ApiModelProperty("房屋基本信息")
    private AbnormalInfo abnormalInfo ;

    @ApiModelProperty("入住人员信息及房屋隐患")
    private List<CheckFormResponse> checkFormResponses;

    @ApiModelProperty("核实信息")
    private CheckFormResponse checkResidentInfo;
}
