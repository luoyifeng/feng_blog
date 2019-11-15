package com.jd.common.utils;

import com.jd.common.constant.PopcConstant;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author yangsong on 2018/12/14.
 */
public final class DateUtil {
    private static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(PopcConstant.Date_Pattern_yyyyMMdd);

    /**
     * 获取指定月的第一天
     *
     * @return
     */
    public static String getFirstDayOfSpecifiedMonth(int minus) {
        LocalDate localDate = LocalDate.now();
        LocalDate startDate = localDate.minus(minus, ChronoUnit.MONTHS);
        startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), 1);
        return dtf2.format(startDate);
    }

    /**
     * 获取当前月最后一天
     *
     * @return
     */
    public static String getLastDayOfSpecifiedMonth() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return dtf2.format(localDate);
    }

}
