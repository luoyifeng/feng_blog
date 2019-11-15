package com.jd.service.residentinfo.model;

import java.util.List;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangsong6
 */
@Data
public class ResidentInfoRequest extends PageVo {

    @ApiModelProperty("姓名")
    private String residentName;

    @ApiModelProperty("证件号码")
    private String residentId;

    @ApiModelProperty("户籍地址")
    private String censusRegister;

    @ApiModelProperty("居住地址")
    private String habitantAddress;
    
    @ApiModelProperty("人员情况")
    private String specialMark;
    
    @ApiModelProperty("人员情况")
    private List<String> specialMarks;

}