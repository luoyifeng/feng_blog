package com.jd.service.houseinfo.service;

import com.jd.service.houseinfo.domain.HouseBasicInfo;
import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.houseinfo.model.HouseBasicInfoResponse;
import com.jd.service.houseinfo.model.HouseQueryRequest;

import java.util.List;

/**
 * @author yangsong on 2018/12/6.
 */
public interface HouseInfoService {

    /**
     * 根据条件查询列表信息
     *
     * @param houseQueryRequest
     * @return
     */
    List<HouseQueryInfo> queryByCondition(HouseQueryRequest houseQueryRequest);

    /**
     * 根据条件查询列表信息
     *
     * @param houseQueryRequest
     * @return
     */
    Integer queryCountByCondition(HouseQueryRequest houseQueryRequest);

    /**
     * 根据房产总数据ID查询房屋基本信息
     *
     * @param proCollId
     * @return
     */
    HouseBasicInfoResponse queryHouseBasicInfoByProCollId(Long proCollId);

    /**
     * 房屋基本信息修改
     * @param houseBasicInfo
     * @return
     */
    Integer updateHouseBasicInfo(HouseBasicInfo houseBasicInfo);
}
