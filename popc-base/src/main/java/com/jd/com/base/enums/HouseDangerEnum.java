package com.jd.com.base.enums;

public enum HouseDangerEnum {
    danger1(1, "存在私自建等违法建筑"),
    danger2(2, "多人混居群租房"),
    danger3(3, "违规存储危险易爆物品"),
    danger4(4, "消防通道不畅"),
    danger5(5, "不符安全标准三合一场所"),
    danger6(6, "其他");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    HouseDangerEnum(int statusCode, String statusMsg) {
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
        HouseDangerEnum[] enums = values();
        for (HouseDangerEnum em : enums) {
            if (em.getStatusCode() == value) {
                return em.getStatusMsg();
            }
        }
        return null;
    }
}
