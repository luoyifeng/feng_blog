package com.jd.service.surveyvisit.model;

import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 核实结果
 * @author yangsong on 2018/12/5.
 */
@Data
public class CheckResult {

    @ApiModelProperty("寄住人员")
    private List<ResidentsInfoResponse> lodgePersons;

    @ApiModelProperty("房屋出租")
    private List<ResidentsInfoResponse> rentPersons;

    @ApiModelProperty("其他原因")
    private String otherReason;

}
