package com.jd.popc.service.communityofficer;

import com.google.common.collect.Lists;
import com.jd.popc.mapper.CommunityOfficerMapper;
import com.jd.popc.mapper.HouseBasicInfoMapper;
import com.jd.service.communityinfo.domain.CommunityInfo;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRelation;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.communityinfo.model.OfficerVo;
import com.jd.service.communityinfo.service.CommunityOfficerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangsong on 2018/12/8.
 */
@Service
@Slf4j
public class CommunityOfficerServiceImpl implements CommunityOfficerService {

    @Resource
    private HouseBasicInfoMapper houseBasicInfoMapper;

    @Resource
    private CommunityOfficerMapper communityOfficerMapper;

    @Override
    public List<CommunityOfficerResponse> queryByCondition(CommunityOfficerRequest request) {
        request.setCurrentPage((request.getCurrentPage() - 1) * request.getOffset());

        List<CommunityOfficerResponse> communityOfficerResponse = new ArrayList<>();

        Map<Integer, CommunityOfficerResponse> mapping = new HashMap<>();
        for (CommunityOfficerResponse oC : communityOfficerMapper.queryByCondition(request)) {
            if (mapping.get(oC.getCommunityId()) != null) {
                mapping.get(oC.getCommunityId()).setOfficerName(mapping.get(oC.getCommunityId()).getOfficerName() + "、" + oC.getOfficerName());
            } else {
                oC.setCommunityNum(houseBasicInfoMapper.selectHouseCountByCommunityName(oC.getCommunityName()));
                mapping.put(oC.getCommunityId(), oC);
            }
        }
        for (Object cinfo : mapping.values().toArray()) {
            communityOfficerResponse.add((CommunityOfficerResponse) cinfo);
        }
        return communityOfficerResponse;
    }


    @Override
    public Integer queryCountByCondition(CommunityOfficerRequest request) {
        return communityOfficerMapper.queryCountByCondition(request);
    }

    @Override
    public List<OfficerVo> queryOfficeInfoByCommunityId(int id) {
        return communityOfficerMapper.queryOfficeInfoByCommunityId(id);
    }

    @Override
    public List<CommunityInfo> queryCommunityByName(String communityName) {
        List<CommunityInfo> communityInfos = communityOfficerMapper.queryCommunityByName(communityName);
        communityInfos.stream().forEach(communityInfo -> {
            CommunityOfficerRequest request = new CommunityOfficerRequest();
            request.setCommunityName(communityInfo.getCommunityName());
            List<CommunityOfficerResponse> officers = communityOfficerMapper.queryByCondition(request);

            List<OfficerInfo> oos = Lists.newArrayList();
            if (officers != null && officers.size() > 0) {
                oos = officers.stream().map(o -> {
                    OfficerInfo officerInfo = new OfficerInfo();
                    officerInfo.setId(o.getId());
                    officerInfo.setOfficerName(o.getOfficerName());
                    officerInfo.setOfficerNo(o.getOfficerNo());
                    return officerInfo;
                }).collect(Collectors.toList());
            }

            communityInfo.setOfficerInfos(oos);
        });
        return communityInfos;
    }

    @Override
    public List<OfficerInfo> queryOfficerByName(String officerName) {
        return communityOfficerMapper.queryOfficerByName(officerName);
    }

    @Override
    public int detachCommunityOfficerRelation(CommunityOfficerRelation relation) {
        System.out.println(relation);
        return communityOfficerMapper.detachCommunityOfficerRelation(relation);
    }

    @Override
    public int saveCommunityOfficerRelation(CommunityOfficerRelation relation) {
        //先删除该小区关联的所有警员
        CommunityOfficerRelation r = new CommunityOfficerRelation();
        r.setCommunityId(relation.getCommunityId());
        this.detachCommunityOfficerRelation(r);

        //再重新关联
        List<Integer> officerIds = relation.getOfficerIds();
        if (officerIds == null || officerIds.size() == 0) {
            return 1;
        }

        officerIds = officerIds.stream().filter(id -> id != null).collect(Collectors.toList());
        if (officerIds == null || officerIds.size() == 0) {
            return 1;
        }
        relation.setOfficerIds(officerIds);
        int saveResult = communityOfficerMapper.saveCommunityOfficerRelation(relation);
        return saveResult;
    }

    @Override
    public int saveSingleCommunityOfficerRelation(CommunityOfficerRelation relation) {
        int saveResult = communityOfficerMapper.saveCommunityOfficerRelation(relation);
        return saveResult;
    }

    @Override
    public int updateByPrimaryKeySelective(CommunityInfo relation) {
        return communityOfficerMapper.updateByPrimaryKeySelective(relation);
    }

    @Override
    public int insertNewCommunity(CommunityInfo relation) {
        communityOfficerMapper.insert(relation);
        return relation.getId();
    }

    @Override
    public int deleteCommunityOfficerRelationByCommunityId(int communityId) {
        int id = communityOfficerMapper.deleteCommunityOfficerRelationByCommunityId(communityId);
        return id;
    }

    @Override
    public int deleteCommunityInfoByPrimaryKey(int communityId) {
        int id = communityOfficerMapper.deleteCommunityInfoByPrimaryKey(communityId);
        return id;
    }


}
