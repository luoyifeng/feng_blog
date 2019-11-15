package com.jd.service.summary.model;

import lombok.Data;

/**
 * @author yangsong on 2019/2/27.
 */
@Data
public class HouseDetails {
    private String communityName;
    private String officer;
    private Integer total;
    private Integer self;
    private Integer rent;
    private Integer empty;
    private Integer todo;
}
