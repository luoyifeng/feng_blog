package com.jd.common.utils;

/**
 * @author yangsong on 2018/12/21.
 */
public final class StringUtil {

    /**
     * 如果字符串是 N 或 NULL 或 "" 则返回 null，否则返回原字符串
     *
     * @param source
     * @return
     */
    public static String trimToNull(String source) {
        if((source != null && (source.trim().equalsIgnoreCase("N") ||
                source.trim().equalsIgnoreCase("NULL"))) || "".equals(source)) {
            source = null;
        }

        return source;
    }

    /**
     * 如果字符串是 N 或 NULL 则返回 ""，否则返回原字符串
     *
     * @param source
     * @return
     */
    public static String trimToEmpty(String source) {
        if(source == null || source.trim().equalsIgnoreCase("N") || source.trim().equalsIgnoreCase("NULL")) {
            source = "";
        }

        return source;
    }
}
