package com.jd.service.surveyvisit.model;

import com.jd.com.base.enums.JudgeAbnormalEnum;
import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yangsong6
 */
@Data
public class AbnormalInfoRequest extends PageVo {

//    @ApiModelProperty("自增主键")
//    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("小区区域")
    private String communityDistrict;

    @ApiModelProperty("小区名称")
    private String communityName;

    @ApiModelProperty("楼栋名称")
    private String apartmentNum;

    @ApiModelProperty("单元")
    private String houseUnit;

    @ApiModelProperty("房（室）号")
    private String roomNum;

    @ApiModelProperty("异常类型")
    private String abnormalType;

    @ApiModelProperty("是否处理异常: 0 已处理; 1 未处理")
    private Integer solveStatus;

    @ApiModelProperty("登录人的警号")
    private String officerNo;

    @ApiModelProperty("小区名称")
    private List<String> communityNames;

    @ApiModelProperty("异常判定时间")
    private String judgeAbnormalTime;

    @ApiModelProperty("房东姓名")
    private String landlordName;

    @ApiModelProperty("姓名")
    private String commonName;

    @ApiModelProperty("房屋特殊标注")
    private String houseSpecialMark;

    @ApiModelProperty("房屋特殊标注集合")
    private List<String> houseSpecialMarkList;

    @ApiModelProperty("房屋隐患")
    private String judgeDanger;

    @ApiModelProperty("走访人员")
    private String visitPerson;

    @ApiModelProperty("核实人员")
    private String checkPerson;

    @ApiModelProperty("走访时间")
    private String visitDate;
}