package com.jd.com.base.enums;

import java.util.TreeMap;

public enum ExceptionEnum {
    SystemError(0,"SystemError","系统错误"),
    ErrorUNameAndPWord(501, "false", "用户名或密码错误"),
    ErrorArgument(2, "ErrorArgument", "参数错误"),
    RightError(3, "false", "权限不足"),
    NoLogin(4, "NoLogin", "后台用户没有登录"),
    NoRight(101,"NoRight","用户没有在此系统注册或者没有分配权限"),
    NoManageRight(88,"NoManageRight"," 用户没有后台角色"),
    ErrorLoginTimeOut(5, "ErrorLoginTimeOut", "登陆超时"),
    NoUrmRight(302,"NoUrmRight","用户没有分配权限"),

    DisplayNoLogin(6, "DisplayNoLogin", "前台用户没有登录"),
    DisplayErrorLoginTimeOut(7, "DisplayErrorLoginTimeOut", "登陆超时"),

    ErrorUNknow(9, "ErrorUNknow", "未知错误"),
    ErrorSqlArgument(8,"ErrorSqlArgument","存在sql注入风险"),
    CacheError(31, "CacheError", "缓存服务器异常"),
    CacheRefreshSuccess(32,"CacheRefreshSuccess","缓存刷新成功"),
    //报表异常
    // 成功
    Success(100,"成功"),
    //失败--报表未找到
    ErrorNotFound(12,"失败--报表未找到"),
    //失败--权限不足
    ErrorNoRight(13, "失败--权限不足"),
    //失败--登陆超时
    ErrorNoLogin(14,"失败--登陆超时"),
    //失败--未知错误
    ErrorUnknown(19,"失败--未知错误"),
    //目录存在报表
    ExistReport(18,"当前目录其他用户存在报表,不能删除。"),
    RoleExistUser(28,"选中角色被用户使用，不能删除。"),
    PortalExistMenu(38,"选中样式被菜单使用,不能删除。"),
    NOExistDrillReport(20,"不存在下钻报表"),
    ReportInMenuUse(98," 报表还在前台菜单中使用，请先移除使用配置。"),
    ReportInChildUse(99," 报表还在下钻报表中使用，请先移除使用配置。"),
    ErrorReportStatus(201,"报表不可用"),
    ReportNotFound(203,"报表不存在"),
    ErrorReportApproval(202,"报表未上线"),
    ExternalLinkReport(204,"外链报表不支持下载"), ;


    private Integer code;
    private String name;
    private String description;

    /**
     * @param description 中文描述
     */
    private ExceptionEnum(String description) {
        this.description = description;
    }

    /**
     * @param code        数字编码
     * @param description 中文描述
     */
    private ExceptionEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @param name        英文编码名称
     * @param description 中文描述
     */
    private ExceptionEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @param code        数字编码
     * @param name        英文编码名称
     * @param description 中文描述
     */
    private ExceptionEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }


    /**
     * 获取枚举类型数值编码
     */
    public Integer toCode() {
        return this.code == null ? Integer.valueOf(this.ordinal()) : this.code;
    }

    /**
     * 获取枚举类型英文编码名称
     */
    public String toName() {
        return this.name == null ? this.name() : this.name;
    }

    /**
     * 获取枚举类型中文描述
     */
    public String toDescription() {
        return this.description;
    }

    /**
     * 获取枚举类型中文描述
     */
    @Override
    public String toString() {
        return this.description;
    }

    /**
     * 按数值获取对应的枚举类型
     *
     * @param code 数值
     * @return 枚举类型
     */
    public static ExceptionEnum enumValueOf(Integer code) {
        ExceptionEnum[] values = ExceptionEnum.values();
        ExceptionEnum v = null;
        for (int i = 0; i < values.length; i++) {
            if (code.equals(values[i].toCode())) {
                v = values[i];
                break;
            }
        }
        return v;
    }

    /**
     * 按英文编码获取对应的枚举类型
     *
     * @param name 英文编码
     * @return 枚举类型
     */
    public static ExceptionEnum enumValueOf(String name) {
        ExceptionEnum[] values = ExceptionEnum.values();
        ExceptionEnum v = null;
        for (int i = 0; i < values.length; i++) {
            if (name.equalsIgnoreCase(values[i].toName())) {
                v = values[i];
                break;
            }
        }
        return v;
    }

    /**
     * 获取枚举类型的所有<数字编码,中文描述>对
     *
     * @return
     */
    public static TreeMap<Integer, String> toCodeDescriptionMap() {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        for (int i = 0; i < ExceptionEnum.values().length; i++) {
            map.put(ExceptionEnum.values()[i].toCode(), ExceptionEnum.values()[i].toDescription());
        }
        return map;
    }

    /**
     * 获取枚举类型的所有<英文编码名称,中文描述>对
     *
     * @return
     */
    public static TreeMap<String, String> toNameDescriptionMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (int i = 0; i < ExceptionEnum.values().length; i++) {
            map.put(ExceptionEnum.values()[i].toName(), ExceptionEnum.values()[i].toDescription());
        }
        return map;
    }
}
