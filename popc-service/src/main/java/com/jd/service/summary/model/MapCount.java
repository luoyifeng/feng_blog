package com.jd.service.summary.model;

import lombok.Data;


@Data
public class MapCount {
	
    private String communityName;
    /**
             * 房屋总数
     */
    private int total;
    /**
              * 自住套数
     */
    private int self;
    /**
             * 出租套数
     */
    private int rent;
    /**
     * 空置套数
     */
    private int empty;
    /**
     * 待核套数
     */
    private int todo;
    
    /**
     * 人口总数
     */
    private int today;
    /**
     * 常住人口
     */
    private int todayNumber;
    /**
     * 暂住人口
     */
    private int todayNumber2;
    /**
     * 寄住人口
     */
    private int todayNumber3;
    /**
     * 其他人口
     */
    private int todayNumber4;
}
