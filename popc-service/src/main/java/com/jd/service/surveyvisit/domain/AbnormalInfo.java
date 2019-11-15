package com.jd.service.surveyvisit.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 处理异常信息列表 映射数据库字段
 * @author yangsong6
 */
@Data
public class AbnormalInfo {

    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("异常类型")
    private String abnormalType;

    @ApiModelProperty("异常信息")
    private String abnormalInfo;

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

    @ApiModelProperty("房屋状态")
    private String houseStatus;

    @ApiModelProperty("房东姓名")
    private String landlordName;

    @ApiModelProperty("房东身份证")
    private String landlordId;

    @ApiModelProperty("联系方式")
    private String landlordPhone;

    @ApiModelProperty("判定异常时间")
    private String judgeAbnormalTime;

    @ApiModelProperty("负责人--即判定异常操作人")
    private String officerName;

    @ApiModelProperty("联系方式--即判定异常操作人")
    private String officerPhone;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否处理异常: 0 已处理; 1 未处理")
    private Integer solveStatus;

    @ApiModelProperty("房屋特殊标注")
    private String houseSpecialMark;

    @ApiModelProperty("购物次数")
    private Long shoppingTimes;

//    @ApiModelProperty("特殊物品")
//    private String specialGoods;

    @ApiModelProperty("标准分数")
    private String standardScore;
    
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("关系")
    private String relation;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("民族")
    private String nation;

    @ApiModelProperty("公民身份证号码")
    private String idNumber;

    @ApiModelProperty("户籍地址")
    private String permanentAddress;

    @ApiModelProperty("是否流出")
    private String outflow;

    @ApiModelProperty("流出原因及详址")
    private String outflowInfo;

    @ApiModelProperty("案底情况")
    private String caseBackGround;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("核实人员")
    private String checkPerson;

    @ApiModelProperty("核实人员电话")
    private String checkPersonPhone;

    @ApiModelProperty("走访人员")
    private String visitPerson;
    
    @ApiModelProperty("工作单位/服务处所")
    private String workUnit;
    
    @ApiModelProperty("职务")
    private String postName;
    
    @ApiModelProperty("走访时间")
    private String visitTime;
}