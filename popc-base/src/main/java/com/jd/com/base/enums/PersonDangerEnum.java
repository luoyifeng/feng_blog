package com.jd.com.base.enums;

public enum PersonDangerEnum {
    danger1(1, "有精神障碍患者"),
    danger2(2, "有生活失意心态失衡对社会不满人员"),
    danger3(3, "有个人极端暴力者"),
    danger4(4, "有关注人员"),
    danger5(5, "其它");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    PersonDangerEnum(int statusCode, String statusMsg) {
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
        PersonDangerEnum[] enums = values();
        for (PersonDangerEnum em : enums) {
            if (em.getStatusCode() == value) {
                return em.getStatusMsg();
            }
        }
        return null;
    }
}
