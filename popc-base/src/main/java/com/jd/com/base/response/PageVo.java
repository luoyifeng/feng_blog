package com.jd.com.base.response;

import lombok.Data;

/**
 * @author yangsong on 2018/12/10.
 */
@Data
public class PageVo {
    private Integer currentPage;
    private Integer totalSize;
    private Integer offset = 10;
}
