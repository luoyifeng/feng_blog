package com.jd.service.userright.model;

import com.google.common.collect.Lists;
import com.jd.common.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangsong on 2018/12/9.
 */
@Data
public class MenuResponse {

    @ApiModelProperty("菜单ID")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String name;

//    @ApiModelProperty("该菜单下子菜单")
//    private List<MenuResponse> subMenus;

    public static List<MenuResponse> getDefaultMenus() {
        return getAllMenus().stream().filter(menuResponse -> !menuResponse.getId().equals(1) && !menuResponse.getId().equals(5) && !menuResponse.getId().equals(6)).collect(Collectors.toList());
    }

    public static List<MenuResponse> getAllMenus() {
        List<MenuResponse> menus = Lists.newArrayList();
        MenuResource[] allMenus = MenuResource.values();
        for(MenuResource resource : allMenus) {
            MenuResponse menuResponse = new MenuResponse();
            menuResponse.setId(resource.getId());
            menuResponse.setName(resource.getName());
            menus.add(menuResponse);
        }
        return menus;
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(getAllMenus()));
        System.out.println(JsonUtil.toJson(getDefaultMenus()));
    }

}
