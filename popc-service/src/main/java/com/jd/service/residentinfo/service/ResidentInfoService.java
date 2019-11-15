package com.jd.service.residentinfo.service;

import com.jd.service.residentinfo.domain.ResidentInfo;
import com.jd.service.residentinfo.model.ResidentInfoRequest;
import com.jd.service.residentinfo.model.ResidentInfoResponse;

import java.util.List;

/**
 * @author yangsong on 2018/12/10.
 */
public interface ResidentInfoService {

    /**
     * 根据条件查询人口信息列表
     *
     * @param residentInfoRequest
     * @return
     */
    List<ResidentInfo> queryByCondition(ResidentInfoRequest residentInfoRequest);

    /**
     * 根据条件查询人口信息列表
     *
     * @param residentInfoRequest
     * @return
     */
    Integer queryCountByCondition(ResidentInfoRequest residentInfoRequest);

    /**
     * 根据id查询人口信息
     *
     * @param id
     * @return
     */
    ResidentInfoResponse queryById(Long id);

    /**
     * 插入一条记录
     * @param info
     * @return
     */
    int insert(ResidentInfo info);
}
