package com.jd.service.residentinfo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong6
 */
@Data
public class ResidentInfoResponse {

    @ApiModelProperty("基本信息")
    private String basicInfo;

    @ApiModelProperty("房屋信息")
    private String houseInfo;

    @ApiModelProperty("单位信息")
    private String companyInfo;

    @ApiModelProperty("涉警犯罪信息")
    private String criminalInfo;
    
    @ApiModelProperty("重点")
    private String zMark;
    
    @ApiModelProperty("风险")
    private String fMark;
    
    @ApiModelProperty("涉警")
    private String sMark;

}