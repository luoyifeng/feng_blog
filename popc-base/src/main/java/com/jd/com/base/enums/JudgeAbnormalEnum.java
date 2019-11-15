package com.jd.com.base.enums;

public enum JudgeAbnormalEnum {
    ABNORMAL_WATER_USE(1, "用水异常"),
    VACANT_SUBLEASE(2, "用水疑似空转租"),
//    SPECIAL_GOODS(3, "购买特殊物品"),
    EMPTY_SHOPPING(3, "空房购物");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    JudgeAbnormalEnum(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return the statusMsg
     */
    public String getStatusMsg() {
        return statusMsg;
    }

    public static String getShow(Integer value) {
        JudgeAbnormalEnum[] enums = values();
        for (JudgeAbnormalEnum em : enums) {
            if (em.getStatusCode() == value) {
                return em.getStatusMsg();
            }
        }
        return null;
    }
}
