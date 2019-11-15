package com.jd.com.base.enums;

/**
 * @description:
 * @author:luoyifeng
 **/
public enum HouseStatusEnum {
    OWNER_OCCUPATION(0, "自住"),
    RENT_OUT(1, "出租"),
    LEAVE_UNUSED(2, "空置");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    HouseStatusEnum(int statusCode, String statusMsg) {
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
}
