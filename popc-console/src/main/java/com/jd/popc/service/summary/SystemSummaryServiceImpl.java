package com.jd.popc.service.summary;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jd.common.constant.PopcConstant;
import com.jd.popc.mapper.AbnormalInfoMapper;
import com.jd.popc.mapper.CheckListMapper;
import com.jd.popc.mapper.CommunityOfficerMapper;
import com.jd.popc.mapper.HouseQueryInfoMapper;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.summary.model.*;
import com.jd.service.summary.service.SystemSummaryService;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;
import com.jd.service.surveyvisit.model.CheckPerson;
import com.jd.service.wateruse.model.TrendVue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangsong on 2019/2/27.
 */
@Slf4j
@Service
public class SystemSummaryServiceImpl implements SystemSummaryService {

    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private CheckListMapper checkListMapper;
    @Resource
    private HouseQueryInfoMapper houseQueryInfoMapper;
    @Resource
    private CommunityOfficerMapper communityOfficerMapper;
    @Resource
    private CommonUtils commonUtils;

    @Override
    public List<TotalSummary> totalSummary() {
        List<TotalSummary> allData = Lists.newArrayList();
        AbnormalInfoRequest abnormalInfoRequest = new AbnormalInfoRequest();
        abnormalInfoRequest.setJudgeAbnormalTime(PopcConstant.yyyymmddSDF.format(LocalDate.now()));
        Integer todayNumber = abnormalInfoMapper.queryCountByCondition(abnormalInfoRequest);

        TotalSummary today = new TotalSummary();
        today.setLabel("今日判断异常数");
        today.setNumber(todayNumber);
        allData.add(today);

        //查询所有未解决的异常
        abnormalInfoRequest = new AbnormalInfoRequest();
        Integer totalNumber = abnormalInfoMapper.queryCountByCondition(abnormalInfoRequest);
        TotalSummary totalSummary = new TotalSummary();
        totalSummary.setLabel("总房屋异常数");
        totalSummary.setNumber(totalNumber);
        allData.add(totalSummary);

        Integer visitNumber = checkListMapper.queryTotalVisits();
        TotalSummary visitCheck = new TotalSummary();
        visitCheck.setLabel("走访核实数");
        visitCheck.setNumber(visitNumber);
        allData.add(visitCheck);

        TotalSummary todo = new TotalSummary();
        todo.setLabel("待访问核实数");
        todo.setNumber(totalNumber - visitNumber);
        allData.add(todo);

        return allData;
    }

    @Override
    public List<TotalSummary> totalSummary(String start,String end) {
        List<TotalSummary> allData = Lists.newArrayList();
        AbnormalInfoRequest abnormalInfoRequest = new AbnormalInfoRequest();
        abnormalInfoRequest.setJudgeAbnormalTime(PopcConstant.yyyymmddSDF.format(LocalDate.now()));
        Integer todayNumber = abnormalInfoMapper.queryCountByCondition(abnormalInfoRequest);

        TotalSummary today = new TotalSummary();
        today.setLabel("今日判断异常数");
        today.setNumber(todayNumber);
        allData.add(today);

        //查询所有未解决的异常
        Map m = abnormalInfoMapper.queryCountByDate(start,end);
        TotalSummary totalSummary = new TotalSummary();
        totalSummary.setLabel("总房屋异常数");
        totalSummary.setNumber(m.get("total0")==null?0:((Long) m.get("total0")).intValue());
        allData.add(totalSummary);

        TotalSummary visitCheck = new TotalSummary();
        visitCheck.setLabel("走访核实数");
        visitCheck.setNumber(m.get("total1")==null?0:((Long) m.get("total1")).intValue());
        allData.add(visitCheck);

        TotalSummary todo = new TotalSummary();
        todo.setLabel("待访问核实数");
        todo.setNumber(m.get("total2")==null?0:((Long) m.get("total2")).intValue());
        allData.add(todo);

        return allData;
    }
    
    @Override
    public TotalSummary totalList(String type,String start,String end) {
    	TotalSummary today = new TotalSummary();
    	List<AbnormalInfo> allData =null;
    	AbnormalInfo temp=null;
    	if("今日判断异常数".equals(type)) {
    		allData =abnormalInfoMapper.queryTotalSummaryList();
    	}else if("总房屋异常数".equals(type) || "走访核实数".equals(type) || "待访问核实数".equals(type)) {
    		allData = abnormalInfoMapper.queryTotalListByType(type,start,end);
    	}else if("走访反馈为自住".equals(type) || "走访反馈为出租".equals(type) || "走访反馈为空置".equals(type)) {
    		allData = abnormalInfoMapper.queryHouseTotalListByType(type,start,end);
    	}else if("总走访人数".equals(type)||"核实常住人口".equals(type) || "核实暂住人口".equals(type) || "核实寄住人口".equals(type)|| "核实其他人口".equals(type)) {
    		allData=new ArrayList();
    		List<CheckForm> checkFormList = checkListMapper.queryPieCountByDate(start,end);
     		 for(CheckForm check:checkFormList) {
            	String lodgePersons=check.getLodgePerson();
            	String houseRent=check.getHouseRent();
            	if(StringUtils.isNotBlank(lodgePersons)||StringUtils.isNotBlank(houseRent)) {
            		if(StringUtils.isNotBlank(lodgePersons)) {
                		List<AbnormalInfo> list=splitFields2(lodgePersons, check);
                		for(AbnormalInfo flag:list) {
                			//常住、暂住、寄住、其他
                			if("常住".equals(flag.getRelation())&&"核实常住人口".equals(type)) {
                				allData.add(flag);
                			}else if("暂住".equals(flag.getRelation())&&"核实暂住人口".equals(type)){
                				allData.add(flag);
                			}else if("寄住".equals(flag.getRelation())&&"核实寄住人口".equals(type)){
                				allData.add(flag);
                			}else if("其他".equals(flag.getRelation())&&"核实其他人口".equals(type)){
                				allData.add(flag);
                			}else if("总走访人数".equals(type)){
                				allData.add(flag);
                			}
                		}
                	}
            		if(StringUtils.isNotBlank(houseRent)) {
                		List<AbnormalInfo> list=splitFields2(houseRent, check);
                		for(AbnormalInfo flag:list) {
                			//常住、暂住、寄住、其他
                			if("常住".equals(flag.getRelation())&&"核实常住人口".equals(type)) {
                				allData.add(flag); 
                			}else if("暂住".equals(flag.getRelation())&&"核实暂住人口".equals(type)){
                				allData.add(flag); 
                			}else if("寄住".equals(flag.getRelation())&&"核实寄住人口".equals(type)){
                				allData.add(flag);
                			}else if("其他".equals(flag.getRelation())&&"核实其他人口".equals(type)){
                				allData.add(flag);
                			}else if("总走访人数".equals(type)){
                				allData.add(flag);
                			}
                		}
                	}
            	}
            }
    	}
    	today.setLabel(type);
        today.setAllData(allData);
        return today;
    }
    private List<AbnormalInfo> splitFields2(String lodgePersons, CheckForm checkForm) {
    	// 姓名 关系 性别 民族 公民身份证号码 户籍地址 是否流出 流出原因及详址 案底情况 
    	//工作单位/服务处所 职务 联系方式 时间  核实人员 走访人员

        return Stream.of(lodgePersons.split(";", -1)).map(str -> {
            String[] lps = str.split(",",-1);
            if (lps != null && lps.length >= 9) {
            	AbnormalInfo temp=new AbnormalInfo();
            	temp.setName(lps[0]);
            	temp.setRelation(lps[1]);
            	temp.setSex(lps[2]);
            	temp.setNation(lps[3]);
            	temp.setIdNumber(lps[4]);
            	temp.setPermanentAddress(lps[5]);
            	temp.setOutflow(lps[6]);
            	temp.setOutflowInfo(lps[7]);
//            	temp.setCaseBackGround(lps[8]);
            	temp.setWorkUnit(lps[8]);
            	temp.setPostName(lps[9]);
            	temp.setPhone(lps[10]);
            	temp.setVisitTime(lps[11]);
//            	temp.setCheckPerson(lps[13]);
//            	temp.setVisitPerson(lps[14]);
                // 单独获得案底情况
                if (StringUtils.isNotEmpty(temp.getIdNumber())) {
                    List<String> personTags = commonUtils.getPersonTags(Collections.singletonList(temp.getIdNumber()));
                    temp.setCaseBackGround(StringUtils.join(personTags, ','));
                }

                // 补充核实人员和走访人员
                String visitPerson = checkForm.getVisitPerson();
                String checkPersonName = "";
                String checkPersonPhone = "";
                if (StringUtils.isNotEmpty(checkForm.getCheckPerson())) {
                    CheckPerson checkPerson = commonUtils.getCheckPerson(checkForm.getCheckPerson());
                    checkPersonName = checkPerson.getName();
                    checkPersonPhone = checkPerson.getContactInfo();
                }
                temp.setCheckPerson(checkPersonName);
                temp.setCheckPersonPhone(checkPersonPhone);
                temp.setVisitPerson(visitPerson);
            	return temp;
            }
            return new AbnormalInfo();
        }).collect(Collectors.toList());
    }
    
    @Override
    public List<TotalSummary> houseTotalSummary(String start,String end) {
        List<TotalSummary> allData = Lists.newArrayList();
         
        Map m = abnormalInfoMapper.queryHouseCountByDate(start,end);

        TotalSummary today = new TotalSummary();
        today.setLabel("走访反馈为自住");
        today.setNumber(m.get("total0")==null?0:((Long) m.get("total0")).intValue());
        allData.add(today);

        TotalSummary totalSummary = new TotalSummary();
        totalSummary.setLabel("走访反馈为出租");
        totalSummary.setNumber(m.get("total1")==null?0:((Long) m.get("total1")).intValue());
        allData.add(totalSummary);

        TotalSummary visitCheck = new TotalSummary();
        visitCheck.setLabel("走访反馈为空置");
        visitCheck.setNumber(m.get("total2")==null?0:((Long) m.get("total2")).intValue());
        allData.add(visitCheck);

        /*TotalSummary todo = new TotalSummary();
        todo.setLabel("走访反馈为待核");
        todo.setNumber(m.get("total3")==null?0:((Long) m.get("total3")).intValue());
        allData.add(todo);*/
        
        Integer todayNumber=0;
        List<CheckForm> checkFormList = checkListMapper.queryPieCountByDate(start,end);
        for(CheckForm check:checkFormList) {
        	String lodgePersons=check.getLodgePerson();
        	if(StringUtils.isNotBlank(lodgePersons)) {
        		List<String> list=splitFields(lodgePersons);
        		todayNumber=todayNumber+list.size();
        	}
        	String houseRent=check.getHouseRent();
        	if(StringUtils.isNotBlank(houseRent)) {
        		List<String> list=splitFields(houseRent);
        		todayNumber=todayNumber+list.size();
        	}
        }
        TotalSummary todo = new TotalSummary();
        todo.setLabel("总走访人数");
        todo.setNumber(todayNumber);
        allData.add(todo);

        return allData;
    }
    
    @Override
    public List<TotalSummary> pieTotalSummary(String start,String end) {
        List<TotalSummary> allData = Lists.newArrayList();
        Integer todayNumber=0;
        Integer todayNumber2=0;
        Integer todayNumber3=0;
        Integer todayNumber4=0;
        List<CheckForm> checkFormList = checkListMapper.queryPieCountByDate(start,end);
        for(CheckForm check:checkFormList) {
        	String lodgePersons=check.getLodgePerson();
        	if(StringUtils.isNotBlank(lodgePersons)) {
        		List<String> list=splitFields(lodgePersons);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        	
        	String houseRent=check.getHouseRent();
        	if(StringUtils.isNotBlank(houseRent)) {
        		List<String> list=splitFields(houseRent);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        }
         
        TotalSummary today = new TotalSummary();
        today.setLabel("核实常住人口");
        today.setNumber(todayNumber);
        allData.add(today);

        TotalSummary totalSummary = new TotalSummary();
        totalSummary.setLabel("核实暂住人口");
        totalSummary.setNumber(todayNumber2);
        allData.add(totalSummary);

        TotalSummary visitCheck = new TotalSummary();
        visitCheck.setLabel("核实寄住人口");
        visitCheck.setNumber(todayNumber3);
        allData.add(visitCheck);

        TotalSummary todo = new TotalSummary();
        todo.setLabel("核实其他人口");
        todo.setNumber(todayNumber4);
        allData.add(todo);

        return allData;
    }
    private List<String> splitFields(String lodgePersons) {
        return Stream.of(lodgePersons.split(";", -1)).map(str -> {
            String flag = "";
            String[] lps = str.split(",", -1);
            if (lps != null && lps.length >= 2) {
            	flag =lps[1];
            }
            return flag;
        }).collect(Collectors.toList());
    }
    
    @Override
    public TrendVue houseCompose() {
        List<Map<String, Object>> houseCompose = houseQueryInfoMapper.queryHouseCompose();
        List<String> dimensionList = Lists.newArrayList();
        List<Double> measureList = Lists.newArrayList();
        for(Map<String, Object> hc:houseCompose) {
            dimensionList.add(String.valueOf(hc.get("hs")));
            measureList.add(Double.valueOf(String.valueOf(hc.get("cnt"))));
        }
        
        TrendVue trendVue = new TrendVue();
        TrendVue.Dimensions dimensions = new TrendVue.Dimensions();
        dimensions.setName("房屋状态");
        dimensions.setData(dimensionList);
        trendVue.setDimensions(dimensions);

        TrendVue.Measures measures = new TrendVue.Measures();
        measures.setName("房屋套数");
        measures.setData(measureList);
        trendVue.setMeasures(Lists.newArrayList(measures));

        return trendVue;
    }

    @Override
    public TrendVue pieCompose() {
    	Integer todayNumber=0;
        Integer todayNumber2=0;
        Integer todayNumber3=0;
        Integer todayNumber4=0;
    	List<CheckForm> pieCompose = checkListMapper.queryPieCompose();
        List<String> dimensionList = Lists.newArrayList();
        List<Double> measureList = Lists.newArrayList();
        for(CheckForm check:pieCompose) {
        	String lodgePersons=check.getLodgePerson();
        	if(StringUtils.isNotBlank(lodgePersons)) {
        		List<String> list=splitFields(lodgePersons);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        	
        	String houseRent=check.getHouseRent();
        	if(StringUtils.isNotBlank(houseRent)) {
        		List<String> list=splitFields(houseRent);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        }
        
        dimensionList.add("常住");
        dimensionList.add("暂住");
        dimensionList.add("寄住");
        dimensionList.add("其他");
        measureList.add(Double.valueOf(todayNumber));
        measureList.add(Double.valueOf(todayNumber2));
        measureList.add(Double.valueOf(todayNumber3));
        measureList.add(Double.valueOf(todayNumber4));
         
        TrendVue trendVue = new TrendVue();
        TrendVue.Dimensions dimensions = new TrendVue.Dimensions();
        dimensions.setName("类型");
        dimensions.setData(dimensionList);
        trendVue.setDimensions(dimensions);

        TrendVue.Measures measures = new TrendVue.Measures();
        measures.setName("数量");
        measures.setData(measureList);
        trendVue.setMeasures(Lists.newArrayList(measures));

        return trendVue;
    }
    
    @Override
    public List<HouseDetails> houseDetails() {
        List<Map<String, Object>> houseDetails = houseQueryInfoMapper.queryHouseComposeByCommunity();
        List<Map<String, String>> communityOfficers = communityOfficerMapper.queryOfficerGroupByCommunity();

        Map<String, String> cos = Maps.newHashMap();
        communityOfficers.forEach(co -> cos.put(StringUtils.trimToEmpty(co.get("communityName")), co.get("officers")));

        Map<String, HouseDetails> communities = Maps.newHashMap();
        houseDetails.stream().forEach(houseDetail -> {

            String communityName = StringUtils.trimToEmpty(String.valueOf(houseDetail.get("communityName")));
            HouseDetails hd;
            if(!communities.keySet().contains(communityName)) {
                hd = new HouseDetails();
                hd.setCommunityName(communityName);
                hd.setOfficer(StringUtils.trimToEmpty(cos.get(communityName)));

                communities.put(communityName, hd);

                setPropertyVal(hd, houseDetail);
            } else {
                hd = communities.get(communityName);
                setPropertyVal(hd, houseDetail);
            }
        });
        //mapCount("沁园春小区","");
        //queryMapCountList("today","沁园春小区","");
        return communities.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    @Override
    public List<PieDetails> pieDetails() {
        List<Map<String, String>> communityOfficers = communityOfficerMapper.queryOfficerGroupByCommunity();
 
        Map<String, String> cos = Maps.newHashMap();
        communityOfficers.forEach(co -> cos.put(StringUtils.trimToEmpty(co.get("communityName")), co.get("officers")));

        Map<String, PieDetails> communities = Maps.newHashMap();
        
    	List<CheckForm> pieCompose = checkListMapper.queryPieCompose();
        for(CheckForm check:pieCompose) {
        	int todayNumber=0;
        	int todayNumber2=0;
        	int todayNumber3=0;
        	int todayNumber4=0;
        	String lodgePersons=check.getLodgePerson();
        	if(StringUtils.isNotBlank(lodgePersons)) {
        		List<String> list=splitFields(lodgePersons);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        	
        	String houseRent=check.getHouseRent();
        	if(StringUtils.isNotBlank(houseRent)) {
        		List<String> list=splitFields(houseRent);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        	
        	//汇总
        	String communityName = StringUtils.trimToEmpty(check.getCommunityName());
        	PieDetails hd=null;
            if(!communities.keySet().contains(communityName)) {
                hd = new PieDetails();
                hd.setCommunityName(communityName);
                hd.setOfficer(StringUtils.trimToEmpty(cos.get(communityName)));

                communities.put(communityName, hd);
            } else {
                hd = communities.get(communityName);
            }
            hd.setTodayNumber(hd.getTodayNumber()+todayNumber);
            hd.setTodayNumber2(hd.getTodayNumber2()+todayNumber2);
            hd.setTodayNumber3(hd.getTodayNumber3()+todayNumber3);
            hd.setTodayNumber4(hd.getTodayNumber4()+todayNumber4);
        }

        return communities.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
    
    @Override
    public TrendVue abnormalTrend() {
        List<Map<String, String>> abnormalTrend = abnormalInfoMapper.queryAbnormalTrend();
        List<String> dimensionList = Lists.newArrayList();
        List<Double> measureList = Lists.newArrayList();
        abnormalTrend.forEach(at -> {
            dimensionList.add(String.valueOf(at.get("ym")));
            measureList.add(Double.valueOf(String.valueOf(at.get("cnt"))));
        });

        TrendVue trendVue = new TrendVue();
        TrendVue.Dimensions dimensions = new TrendVue.Dimensions();
        dimensions.setName("日期");
        dimensions.setData(dimensionList);
        trendVue.setDimensions(dimensions);

        TrendVue.Measures measures = new TrendVue.Measures();
        measures.setName("条数");
        measures.setData(measureList);
        trendVue.setMeasures(Lists.newArrayList(measures));

        return trendVue;
    }

    @Override
    public List<AbnormalTrend> top10() {
        return abnormalInfoMapper.top10();
    }

    private void setPropertyVal(HouseDetails hd, Map<String, Object> houseDetail) {
        String houseStatus = StringUtils.trimToEmpty(String.valueOf(houseDetail.get("hs")));
        Integer cnt = houseDetail.get("cnt") == null ? 0 : Integer.valueOf(houseDetail.get("cnt").toString());
        if("出租".equals(houseStatus)) {
            hd.setRent(cnt);
        } else if("待核".equals(houseStatus)) {
            hd.setTodo(cnt);
        } else if("空置".equals(houseStatus)) {
            hd.setEmpty(cnt);
        } else if("自住".equals(houseStatus)) {
            hd.setSelf(cnt);
        }

        Integer rent = hd.getRent() == null ? 0 : hd.getRent();
        Integer todo = hd.getTodo() == null ? 0 : hd.getTodo();
        Integer empty = hd.getEmpty() == null ? 0 : hd.getEmpty();
        Integer self = hd.getSelf() == null ? 0 : hd.getSelf();
        hd.setTotal(rent + todo + empty + self);
    }
    
    @Override
    public MapCount mapCount(String communityName,String apartmentNum) {
    	MapCount mapCount=new MapCount();
    	//房屋统计
        Map<String, Object> houseCount = houseQueryInfoMapper.queryHouseComposeBy(communityName,apartmentNum);
        if(houseCount!=null) {
        	mapCount.setTotal( ((Long) houseCount.get("total")).intValue());
        	mapCount.setSelf( ((Long) houseCount.get("self")).intValue());
        	mapCount.setRent( ((Long) houseCount.get("rent")).intValue());
        	mapCount.setEmpty( ((Long) houseCount.get("empty")).intValue());
        	mapCount.setTodo( ((Long) houseCount.get("todo")).intValue());
        }
        //人口调查
        int todayNumber=0;
    	int todayNumber2=0;
    	int todayNumber3=0;
    	int todayNumber4=0;
        List<CheckForm> pieCompose = checkListMapper.queryPieComposeBy(communityName,apartmentNum);
        for(CheckForm check:pieCompose) {
        	String lodgePersons=check.getLodgePerson();
        	if(StringUtils.isNotBlank(lodgePersons)) {
        		List<String> list=splitFields(lodgePersons);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        	
        	String houseRent=check.getHouseRent();
        	if(StringUtils.isNotBlank(houseRent)) {
        		List<String> list=splitFields(houseRent);
        		for(String flag:list) {
        			//常住、暂住、寄住、其他
        			if("常住".equals(flag)) {
        				todayNumber=todayNumber+1;
        			}else if("暂住".equals(flag)){
        				todayNumber2=todayNumber2+1;
        			}else if("寄住".equals(flag)){
        				todayNumber3=todayNumber3+1;
        			}else if("其他".equals(flag)){
        				todayNumber4=todayNumber4+1;
        			}
        		}
        	}
        }
        mapCount.setToday(todayNumber+todayNumber2+todayNumber3+todayNumber4);
        mapCount.setTodayNumber(todayNumber);
    	mapCount.setTodayNumber2(todayNumber2);
    	mapCount.setTodayNumber3(todayNumber3);
    	mapCount.setTodayNumber4(todayNumber4);
        return mapCount;
    }
    @Override
    public TotalSummary queryMapCountList(String type,String communityName,String apartmentNum) {
    	TotalSummary today = new TotalSummary();
    	List allData =null;
    	AbnormalInfo temp=null;
    	if("total".equals(type) || "self".equals(type) || "rent".equals(type) || "empty".equals(type) || "todo".equals(type)) {
    		allData = houseQueryInfoMapper.queryHouseListByTypeAndC(type,communityName,apartmentNum);
    	}else if("today".equals(type)||"todayNumber".equals(type) || "todayNumber2".equals(type) || "todayNumber3".equals(type)|| "todayNumber4".equals(type)) {
    		allData=new ArrayList();
    		List<CheckForm> checkFormList = checkListMapper.queryPieListCountBy(type,communityName,apartmentNum);
     		for(CheckForm check:checkFormList) {
            	String lodgePersons=check.getLodgePerson();
            	String houseRent=check.getHouseRent();
            	if(StringUtils.isNotBlank(lodgePersons)||StringUtils.isNotBlank(houseRent)) {
            		if(StringUtils.isNotBlank(lodgePersons)) {
                		List<AbnormalInfo> list=splitFields2(lodgePersons, check);
                		for(AbnormalInfo flag:list) {
                			//常住、暂住、寄住、其他
                			if("常住".equals(flag.getRelation())&&"todayNumber".equals(type)) {
                				allData.add(flag);
                			}else if("暂住".equals(flag.getRelation())&&"todayNumber2".equals(type)){
                				allData.add(flag);
                			}else if("寄住".equals(flag.getRelation())&&"todayNumber3".equals(type)){
                				allData.add(flag);
                			}else if("其他".equals(flag.getRelation())&&"todayNumber4".equals(type)){
                				allData.add(flag);
                			}else if("today".equals(type)){
                				allData.add(flag);
                			}
                		}
                	}
            		if(StringUtils.isNotBlank(houseRent)) {
                		List<AbnormalInfo> list=splitFields2(houseRent, check);
                		for(AbnormalInfo flag:list) {
                			//常住、暂住、寄住、其他
                			if("常住".equals(flag.getRelation())&&"todayNumber".equals(type)) {
                				allData.add(flag);
                			}else if("暂住".equals(flag.getRelation())&&"todayNumber2".equals(type)){
                				allData.add(flag);
                			}else if("寄住".equals(flag.getRelation())&&"todayNumber3".equals(type)){
                				allData.add(flag);
                			}else if("其他".equals(flag.getRelation())&&"todayNumber4".equals(type)){
                				allData.add(flag);
                			}else if("today".equals(type)){
                				allData.add(flag);
                			}
                		}
                	}
            	}
            }
    	}
    	today.setLabel(type);
        today.setHData(allData);
        return today;
    }
}
