package com.jd.popc.mapper;

import com.jd.service.residentinfo.domain.ResidentInfo;
import com.jd.service.residentinfo.model.ResidentInfoRequest;

import java.util.List;

/**
 * @author yangsong6
 */
public interface ResidentInfoMapper {

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
     * 根据主键查询一条记录
     *
     * @param id
     * @return
     */
    ResidentInfo selectByPrimaryKey(Long id);

    /**
     * 新入一条记录
     *
     * @param record
     * @return
     */
    int insert(ResidentInfo record);

}