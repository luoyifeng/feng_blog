package com.jd.popc.service.userright;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.common.constant.PopcConstant;
import com.jd.common.utils.MD5Utils;
import com.jd.popc.mapper.CommunityOfficerMapper;
import com.jd.popc.mapper.UserRightMapper;
import com.jd.service.communityinfo.domain.OfficerInfo;
import com.jd.service.communityinfo.model.CommunityOfficerRequest;
import com.jd.service.communityinfo.model.CommunityOfficerResponse;
import com.jd.service.communityinfo.model.OfficerVo;
import com.jd.service.userright.model.MenuResource;
import com.jd.service.userright.model.MenuResponse;
import com.jd.service.userright.model.OfficerRequest;
import com.jd.service.userright.service.UserRightService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yangsong on 2018/12/9.
 */
@Service
@Slf4j
public class UserRightServiceImpl implements UserRightService {

    @Resource
    private UserRightMapper userRightMapper;
    @Resource
    private CommunityOfficerMapper communityOfficerMapper;

    @Override
    public List<OfficerInfo> queryByCondition(OfficerRequest officerRequest) {
        officerRequest.setCurrentPage((officerRequest.getCurrentPage() - 1) * officerRequest.getOffset());
        return userRightMapper.queryByCondition(officerRequest);
    }

    @Override
    public Integer queryCountByCondition(OfficerRequest officerRequest) {
        return userRightMapper.queryCountByCondition(officerRequest);
    }

    @Override
    public ServiceResponse<String> updateById(OfficerRequest officerRequest) {
        OfficerInfo officerInfo = userRightMapper.selectByPrimaryKey(officerRequest.getId());
        if(officerInfo == null || officerInfo.getId() == null) {
            return ServiceResponse.failure("该警员不存在");
        }

        //如果是删除或禁用警员则需要检查其有无负责的小区
        Byte deleted = officerRequest.getDeleted();
        Byte status = officerRequest.getStatus();
        if((deleted != null && deleted == 1) || (status != null && status == 1)) {
            CommunityOfficerRequest requestParams = new CommunityOfficerRequest();
            requestParams.setOfficerNo(officerInfo.getOfficerNo());
            List<CommunityOfficerResponse> responseList = communityOfficerMapper.queryByCondition(requestParams);
            log.info("updateById:{}", officerRequest.getId());
            if(responseList != null && responseList.size() > 0) {
                return ServiceResponse.failure("该警员有负责的小区，不允许" + ((deleted != null && deleted == 1) ? "删除" : "禁用"));
            }
        }

        userRightMapper.updateById(officerRequest);

        return ServiceResponse.success("成功");
    }

    @Override
    public List<MenuResponse> listMenuResource() {
        return MenuResponse.getDefaultMenus();
    }

    @Override
    public List<MenuResponse> getCurrentUserMenu(String officerNo) {
        List<MenuResponse> allMenus = MenuResponse.getAllMenus();
        List<MenuResponse> rightMenus = Lists.newArrayList();

        //该菜单必须有的 固定写死了 前端页面没有地方分配该菜单
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setId(MenuResource.WaterUse.getId());
        menuResponse.setName(MenuResource.WaterUse.getName());
//        rightMenus.add(menuResponse);

        OfficerInfo officerInfo = userRightMapper.selectByOfficerNo(officerNo);
        if(officerInfo != null && officerInfo.getId() != null) {
            String menuIds = StringUtils.trimToEmpty(officerInfo.getMenuIds());
            Arrays.stream(menuIds.split(",", -1)).forEach(m -> {
                Optional<MenuResponse> matchedMenu = allMenus.stream().filter(a -> a.getId().equals(Integer.valueOf(m))).findFirst();
                if(matchedMenu.isPresent()) {
                    rightMenus.add(matchedMenu.get());
                }
            });
        }

        return rightMenus;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int saveOfficerInfo(OfficerVo officerVo) {
        int saveResult = 0;
        if(officerVo.getId() == null) {
            officerVo.setPassword(MD5Utils.getMD5Str(PopcConstant.Default_PWD));
            saveResult = userRightMapper.insertSelective(officerVo);
            log.info("save officer info generate auto increment id:{}", officerVo.getId());
        } else {
            saveResult = userRightMapper.updateByPrimaryKeySelective(officerVo);
        }

        log.info("save officer info result:{}", saveResult);
        return saveResult;
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    @Override
    public int resetPassword(String id) {
        String pwd = MD5Utils.getMD5Str(PopcConstant.Default_PWD);
        return userRightMapper.resetPassword(id, pwd);
    }

    @Override
    public Integer updatePasswordByOfficerNo(String officerNo, String oldPwd, String newPwd) {
        //先判断之前的密码是不是输入对了
        OfficerInfo officerInfo = userRightMapper.selectByOfficerNo(officerNo);
        if(officerInfo == null || officerInfo.getPassword() == null) {
            return null;
        }

        String pwd = StringUtils.trimToEmpty(officerInfo.getPassword());
        oldPwd = MD5Utils.getMD5Str(StringUtils.trimToEmpty(oldPwd));
        if(!oldPwd.equals(pwd)) {
            return null;
        }

        //再修改
        int updateResult = userRightMapper.updatePasswordByOfficerNo(officerNo, MD5Utils.getMD5Str(newPwd));
        log.info("更新警员密码 officerNo:{}, {}", officerNo, updateResult);
        return updateResult;
    }

    @Override
    public OfficerInfo selectByOfficerNo(String officerNo) {
        return userRightMapper.selectByOfficerNo(officerNo);
    }
}
