package com.jd.popc.service.residentinfo;

import com.jd.common.utils.StringUtil;
import com.jd.popc.mapper.ResidentInfoMapper;
import com.jd.popc.mapper.oracle.ZdryglxxfoMapper;
import com.jd.popc.service.utils.ConnectOracle;
import com.jd.service.residentinfo.domain.ResidentInfo;
import com.jd.service.residentinfo.model.ResidentInfoRequest;
import com.jd.service.residentinfo.model.ResidentInfoResponse;
import com.jd.service.residentinfo.service.ResidentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangsong on 2018/12/10.
 */
@Service
@Slf4j
public class ResidentInfoServiceImpl implements ResidentInfoService {

    @Resource
    private ResidentInfoMapper residentInfoMapper;
    @Resource
    private ZdryglxxfoMapper zdryglxxfoMapper;
    
    @Override
    public List<ResidentInfo> queryByCondition(ResidentInfoRequest request) {
        request.setCurrentPage((request.getCurrentPage() - 1) * request.getOffset());
        List<ResidentInfo> residentInfos = residentInfoMapper.queryByCondition(request);
        residentInfos = residentInfos.stream().map(residentInfo -> {
            String residentSex = StringUtil.trimToNull(residentInfo.getResidentSex());
            if(residentSex != null) {
                residentInfo.setResidentSex(StringUtils.equals("1", residentSex) ? "女" : "男");
            } else {
                residentInfo.setResidentSex("--");
            }

            String contactInfo = StringUtil.trimToNull(residentInfo.getContactInfo());
            if(contactInfo == null) {
                residentInfo.setContactInfo("--");
            }

            String residentId = StringUtil.trimToNull(residentInfo.getResidentId());
            if(residentId == null) {
                residentInfo.setResidentId("--");
            }

            String censusRegister = StringUtil.trimToNull(residentInfo.getCensusRegister());
            if(censusRegister == null) {
                residentInfo.setCensusRegister("--");
            }

            String habitantAddress = StringUtil.trimToNull(residentInfo.getHabitantAddress());
            if(habitantAddress == null) {
                residentInfo.setHabitantAddress("--");
            }
            return residentInfo;
        }).collect(Collectors.toList());

        return residentInfos;
    }

    @Override
    public Integer queryCountByCondition(ResidentInfoRequest residentInfoRequest) {
        return residentInfoMapper.queryCountByCondition(residentInfoRequest);
    }

    @Override
    public ResidentInfoResponse queryById(Long id) {
        ResidentInfoResponse response = new ResidentInfoResponse();
        ResidentInfo residentInfo = residentInfoMapper.selectByPrimaryKey(id);
        if(residentInfo != null) {
            //基本信息
            StringBuilder basicInfoBuilder = new StringBuilder();
            String residentSex = StringUtil.trimToNull(residentInfo.getResidentSex());
            if(residentSex != null) {
                residentSex = StringUtils.equals("1", residentSex) ? "女" : "男";
            } else {
                residentSex = "--";
            }
            basicInfoBuilder.append("<div class=\"el-row\" style=\"margin-bottom: 10px;\"><div class=\"el-col el-col-4\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名</b> ").append(StringUtil.trimToEmpty(residentInfo.getResidentName())).append("</div></div>");
            basicInfoBuilder.append("<div class=\"el-row\" style=\"margin-bottom: 10px;\"><div class=\"el-col el-col-4\"><b>身份证号</b> ").append(StringUtil.trimToEmpty(residentInfo.getResidentId())).append("</div></div>");
            basicInfoBuilder.append("<div class=\"el-row\" style=\"margin-bottom: 10px;\">").append("<div class=\"el-col el-col-6\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别</b> ").append(residentSex).append("</div></div>");
            basicInfoBuilder.append("<div class=\"el-row\" style=\"margin-bottom: 10px;\">").append("<div class=\"el-col el-col-6\"><b>出生年月</b> ").append(StringUtil.trimToEmpty(residentInfo.getBirthDate())).append("</div></div>");
            basicInfoBuilder.append("<div class=\"el-row\" style=\"margin-bottom: 10px;\">").append("<div class=\"el-col el-col-6\"><b>人员类型</b> ").append(StringUtil.trimToEmpty(residentInfo.getResidentType())).append("</div></div>");
            response.setBasicInfo(basicInfoBuilder.toString());

            //房屋信息
            StringBuilder habitantInfoBuilder = new StringBuilder();
            habitantInfoBuilder.append("<div class=\"el-row\"><div class=\"el-col el-col-8\"><b>房屋地址</b> ").append(StringUtil.trimToEmpty(residentInfo.getHabitantAddress())).append("</div>")
                    .append("<div class=\"el-col el-col-8\"><b>产权证号</b> ").append(StringUtil.trimToEmpty(residentInfo.getPropertyRightCertificate())).append("</div></div>");
            response.setHouseInfo(habitantInfoBuilder.toString());

            //单位信息
            StringBuilder companyInfo = new StringBuilder();
            companyInfo.append("<div class=\"el-row\"><div class=\"el-col el-col-8\"><b>单位名称</b> ").append(StringUtil.trimToEmpty(residentInfo.getCompanyInfo())).append("</div>")
                    .append("<div class=\"el-col el-col-8\"><b>单位地址</b> ").append(StringUtil.trimToEmpty(residentInfo.getCompanyAddress())).append("</div></div>");
            response.setCompanyInfo(companyInfo.toString());

            //涉警犯罪信息
            response.setCriminalInfo(StringUtil.trimToEmpty(residentInfo.getCriminalInfo()));
            
            //获取标签
//            Map m=zdryglxxfoMapper.queryZdryglxxById(residentInfo.getResidentId());
            Map m= ConnectOracle.queryZdryglxxById(residentInfo.getResidentId());
            if(m!=null) {
            	if("1".equals(m.get("FL"))) {
            		response.setZMark("1");
            	}
            	if("2".equals(m.get("FL"))) {
            		response.setFMark("1");
            	}
                if(m.get("SA")!=null) {
                	response.setSMark("1");
                }
            }
        }
        
        
        return response;
    }

    /**
     * 插入一条记录
     * @param info
     * @return
     */
    @Override
    public int insert(ResidentInfo info) {
        return residentInfoMapper.insert(info);
    }
}
