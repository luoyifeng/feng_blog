package com.jd.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author yangsong on 2018/12/14.
 */
public final class NumberUtil {

    /**
     * 将小数转化成百分数 进行四舍五入
     *
     * @return
     */
    public static String decimalToPercent(String decimal) {
        Double value;
        try {
            value = Double.valueOf(decimal);
        } catch (Exception e) {
            value = 0.0;
        }

        //获取格式化对象
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        numberFormat.setMinimumFractionDigits(2);

        //最后格式化并输出
        return numberFormat.format(value);
    }

    /**
     * 四舍五入
     *
     * @param decimal
     * @param groupingSize 组大小即整数部分被分割符隔开后每部分有几位
     * @param fractionDigit 小数点后取到第几位
     * @return
     */
    public static String formatDecimal(String decimal, int groupingSize, int fractionDigit) {
        Double value;
        try {
            value = Double.valueOf(decimal);
        } catch (Exception e) {
            value = 0.0;
        }

        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(fractionDigit);
        formatter.setGroupingSize(groupingSize);
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(value);
    }

    /**
     * 将字符串转化成 double 类型的值
     * @param value
     * @return
     */
    public static String toDouble(String value) {
        if(value.contains("%")) {
            value = value.replaceAll("%", "");
            Double d = Double.valueOf(value);
            return String.valueOf(d.doubleValue() / 100);
        }

        return "0.0";
    }

    public static void main(String[] args) {
        System.out.println(decimalToPercent(formatDecimal("-4.450888554202755", 0, 4)));
        System.out.println(toDouble("14.23%"));
        System.out.println(formatDecimal("24.333333333333332", 0, 2));
    }
}
