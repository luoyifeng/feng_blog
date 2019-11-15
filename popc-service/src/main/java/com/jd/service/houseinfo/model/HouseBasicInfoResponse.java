package com.jd.service.houseinfo.model;

import com.jd.service.houseinfo.domain.HouseBasicInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 返回前端页面的房屋基本信息
 *
 * @author yangsong on 2018/12/6.
 */
@Data
public class HouseBasicInfoResponse {

    @ApiModelProperty("基本信息")
    List<HouseBasicInfo> basicInfo;

    @ApiModelProperty("入住人员信息")
    List<ResidentsInfoResponse> residentInfo;

    @ApiModelProperty("房屋隐患")
    HiddenDanger hiddenDanger;

    @ApiModelProperty("交易信息")
    List<String> dealInfo;

    @ApiModelProperty("入住人员标签")
    List<String> personTags;
}
