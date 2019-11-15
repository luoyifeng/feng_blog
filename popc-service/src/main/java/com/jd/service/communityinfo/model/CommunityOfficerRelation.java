package com.jd.service.communityinfo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yangsong on 2018/12/9.
 */
@Data
public class CommunityOfficerRelation {

    @ApiModelProperty("小区表主键id")
    private Integer communityId;

    @ApiModelProperty("警员表主键id")
    private List<Integer> officerIds;
}
