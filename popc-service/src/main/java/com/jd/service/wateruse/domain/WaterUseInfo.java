package com.jd.service.wateruse.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yangsong6
 */
@Data
public class WaterUseInfo {

    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("小区名称")
    private String communityName;

    @ApiModelProperty("小区区域")
    private String communityDistrict;

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

    @ApiModelProperty("上次用水量")
    private String previousWaterConsumption;

    @ApiModelProperty("本次用水量")
    private String currentWaterConsumption;

    @ApiModelProperty("平均月用水量")
    private String avgWaterConsumption;

    @ApiModelProperty("环比增长")
    private String monthOnMonthGrowth;

    @ApiModelProperty("变异系数")
    private String coefficientVariation;

    @ApiModelProperty("Z标准分数")
    private String standardScore;

    @ApiModelProperty("警员警号")
    private String officerNo;

    @ApiModelProperty("判定异常时间")
    private String judgeAbnormalTime;

    @ApiModelProperty("房屋用水状态: 异常,正常")
    private String houseWaterStatus;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("分区信息")
    private String dt;

    @ApiModelProperty("疑似空转租")
    private Boolean suspectRent = false;


    /********二期新增字段********/
    @ApiModelProperty("房屋特殊标注")
    private String houseSpecialMark;

    @ApiModelProperty("购物次数")
    private Long shoppingTimes;

    @ApiModelProperty("疑似空房购物")
    private String emptyShopping;

//    @ApiModelProperty("特殊物品")
//    private String specialGoods;
    /********二期新增字段********/
//
//    @ApiModelProperty("四分位数区间")
//    private String quartile;

}