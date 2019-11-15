package com.jd.common.constant;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * @author yangsong on 2018/12/11.
 */
public final class PopcConstant {
    public static SimpleDateFormat defaultSDF = new SimpleDateFormat(PopcConstant.Date_Pattern_Default);
    public static DateTimeFormatter yyyymmSDF = DateTimeFormatter.ofPattern(PopcConstant.Date_Pattern_yyyyMM);
    public static DateTimeFormatter yyyymmddSDF = DateTimeFormatter.ofPattern(PopcConstant.Date_Pattern_yyyyMMdd);

    public static final String Water_Abnormal_Type = "用水异常";
    public static final String House_Water_Status = "异常";
    public static final String Date_Pattern_Default = "yyyy-MM-dd HH:mm:ss";
    public static final String Date_Pattern_yyyyMMdd = "yyyy-MM-dd";
    public static final String Date_Pattern_yyyyMM = "yyyy-MM";

    public static final Integer Solve_Status_Yes = 0;
    public static final Integer Solve_Status_No = 1;

    public static final String Default_PWD = "People4SQ";

    public static final String Role_Admin = "admin";
    public static final String Role_Officer = "officer";
}
