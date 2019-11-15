package com.jd.service.wateruse.model;

import com.jd.com.base.response.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用水异常前端传值
 *
 * @author yangsong6
 */
@Data
public class WaterUseInfoRequest extends PageVo {

//    @ApiModelProperty("自增主键")
//    private Long id;

    @ApiModelProperty("房产总数据ID")
    private Long proCollId;

    @ApiModelProperty("房屋状态")
    private String houseStatus;

    @ApiModelProperty("指标超出百分比（环比增长）")
    private String monthOnMonthGrowth;

    @ApiModelProperty("用水状态: 异常，正常")
    private String houseWaterStatus;

    @ApiModelProperty("变异系数")
    private String coefficientVariation;

    @ApiModelProperty("Z分数")
    private String standardScore;

    @ApiModelProperty("登录人的警号")
    private String officerNo;

    @ApiModelProperty("小区名")
    private String communityName;

    @ApiModelProperty("疑似空转租")
    private String suspectRent;

    @ApiModelProperty("房屋特殊标注")
    private String houseSpecialMark;

    @ApiModelProperty("房屋特殊标注集合")
    private List<String> houseSpecialMarkList;

    @ApiModelProperty("购物次数")
    private Long shoppingTimes;

    @ApiModelProperty("疑似空房购物")
    private String emptyShopping;

//    @ApiModelProperty("特殊物品")
//    private String specialGoods;

//    @ApiModelProperty("四分位数区间")
//    private String quartile;
}