package com.jd.service.userright.model;

/**
 * 所有的菜单资源
 *
 * @author yangsong on 2018/12/9.
 */
public enum MenuResource {

    /**
     * 用水异常判断
     */
    SystemSummary(0, "系统概览",1, 0),
    CommunityMap(100, "小区地图",1, 0),
    WaterUse(1, "房屋异常判断", 1, 0),
    SurveyVisit(2, "调查走访管理", 1, 0),
    AbnormalHandle(21, "异常处理", 2, 2),
    AbnormalResultView(22, "异常处理结果查看", 2, 2),
    ResidentInfo(3, "人口信息查询", 1, 0),
    HouseInfo(4, "房屋信息查询", 1, 0),
    CommunityOfficer(5, "小区信息管理", 1, 0),
    UserRight(6, "用户权限管理", 1, 0);

    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单层级，共两级
     */
    private Integer level;

    /**
     * 父级菜单id
     */
    private Integer pid;

    MenuResource(Integer id, String name, Integer level, Integer pid) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.pid = pid;
    }

    public static MenuResource enumValueOf(Integer id) {
        for(MenuResource m : MenuResource.values()) {
            if(m.id.equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }


    public static void main(String[] args) {
        System.out.println(MenuResource.enumValueOf(4).getName());
    }
}
