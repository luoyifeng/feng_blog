package com.jd.service.wateruse.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * vue 能显示的格式
 *
 * @author yangsong on 2018/12/12.
 */
@Data
public class TrendVue {

    @ApiModelProperty("维度")
    private Dimensions dimensions;

    @ApiModelProperty("量度")
    private List<Measures> measures;

    @Data
    public static class Dimensions {
        private String name;
        private List<String> data;
    }

    @Data
    public static class Measures {
        private String name;
        private List<Double> data;
    }
}
