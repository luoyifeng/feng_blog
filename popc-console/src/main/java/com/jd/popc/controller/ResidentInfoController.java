package com.jd.popc.controller;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.ResidentInfoAnno;
import com.jd.popc.mapper.oracle.ZdryglxxfoMapper;
import com.jd.popc.service.utils.ConnectOracle;
import com.jd.service.residentinfo.domain.ResidentInfo;
import com.jd.service.residentinfo.model.ResidentInfoRequest;
import com.jd.service.residentinfo.model.ResidentInfoResponse;
import com.jd.service.residentinfo.service.ResidentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author yangsong on 2018/11/29.
 */
@Api(tags = "人口信息查询", description = "ResidentInfoController")
@RestController
@ResidentInfoAnno
@RequestMapping("/resident/info")
@Slf4j
public class ResidentInfoController extends BaseController {

    @Autowired
    private ResidentInfoService residentInfoService;
    @Resource
    private ZdryglxxfoMapper zdryglxxfoMapper;
    
    ThreadPoolExecutor pool=new ThreadPoolExecutor(20,50,60, TimeUnit.MINUTES,  new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

    @ApiOperation(value="根据条件获取人口信息列表", notes="根据条件获取人口信息列表")
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<ResidentInfo>> queryByCondition(@ModelAttribute ResidentInfoRequest request) throws Exception, ExecutionException {
        Integer currentPage = request.getCurrentPage();
        if(currentPage == null) {
            currentPage = 1;
        }
        int count =0;
        List<ResidentInfo> list=null;
        request.setCurrentPage(currentPage);
        String specialMark = request.getSpecialMark();
        if(StringUtils.isBlank(specialMark)) {
        	log.info("单表查询");
        	count = residentInfoService.queryCountByCondition(request);
            log.info("query resident info:{}, {}", currentPage, count);
            list=residentInfoService.queryByCondition(request);
            if(list!=null) {
            	list.stream().forEach(resident -> {
            		//获取标签
//                    Map m=zdryglxxfoMapper.queryZdryglxxById(resident.getResidentId());
					Map m = ConnectOracle.queryZdryglxxById(resident.getResidentId());
                    //人员分类 1重点人员2风险人员
                    String special="无案底人员";
                    if(m!=null) {
                    	if("1".equals(m.get("FL"))) {
                    		special="重点人员";
                    	}else if("2".equals(m.get("FL"))) {
                    		special="风险人员";
                    	}
                        if(m.get("SA")!=null) {
                        	special=special+",涉案人员";
                        }
                    }
                    resident.setSpecialMark(special);
            	});
            }
        }else {
        	log.info("多表复杂查询,查询");
        	request.setCurrentPage(1);
        	request.setOffset(10000);
        	List<Future> results=new ArrayList<Future>();
        	list=residentInfoService.queryByCondition(request);
        	if(list!=null&&list.size()>0) {
        		List<List<ResidentInfo>> partition=Lists.partition(list, 50);
        		for (List<ResidentInfo> item : partition){
        			Future<List<ResidentInfo>> f = pool.submit(new Callable<List<ResidentInfo>>() {
                        public List<ResidentInfo> call() throws Exception {
                        	 //加工参数
                        	 Map<String,ResidentInfo> rfMap=new HashMap();
                        	 List<String> rfList=new ArrayList<String>();
                        	 item.stream().forEach(rf ->{
                        		 rfList.add(rf.getResidentId());
                        	 });
                        	 //获取人员标签
                        	 Map<String,Map> mkMap=new HashMap();
//                        	 List<Map> mList=zdryglxxfoMapper.queryZdryglxxByIds(rfList);
                        	 List<Map> mList=ConnectOracle.queryZdryglxxByIds(rfList);
                        	 mList.stream().forEach(m ->{
                        		 mkMap.put((String) m.get("GMSFHM"), m);
                        	 });
                        	 
                        	 List<ResidentInfo> r= item.stream().filter(m ->{
                        		 Map mk=mkMap.get(m.getResidentId());
                        		 if(mk!=null) {
                        			  //过滤人员
                        			  String fl=(String) mk.get("FL");
                        			  log.info("过滤人员:"+fl);
                          			  if("1".equals(mk.get("FL"))&&specialMark.contains("重点人员")) {
                          				  return true;
                          			  }else if("2".equals(mk.get("FL"))&&specialMark.contains("风险人员")){
                          				  return true;
                          			  }else if(mk.get("SA")!=null&&specialMark.contains("涉案人员")) {
                          				  return true;
                          			  }else {
                          				  return false;
                          			  }
                        		 }else {
                        			  //过滤人员
                          			  if(specialMark.contains("无案底人员")){
                          				  return true;
                          			  }else {
                          				  return false;
                          			  }
                        		 }
                   			   
                   			 }).map(e ->{
                   				Map mk=mkMap.get(e.getResidentId());
                   				String special="无案底人员";
                   				if(mk!=null) {
                   				    //人员分类 1重点人员2风险人员
                                  	if("1".equals(mk.get("FL"))) {
                                  		special="重点人员";
                                  	}else if("2".equals(mk.get("FL"))) {
                                  		special="风险人员";
                                  	}
                                    if(mk.get("SA")!=null) {
                                      	special=special+",涉案人员";
                                    }
                   				}
                 				
                 				e.setSpecialMark(special);
                 				return e;
                 			 }).collect(Collectors.toList());
                        	 
                             return r;
                        }
                    });
        			results.add(f);
        		}
        		list=new ArrayList<ResidentInfo>();
            	for(Future<List<ResidentInfo>> f:results) {
            		list.addAll(f.get());
            	}
            	count =list.size();
        	}
        }
        return ServiceResponse.successWithPageInfo(list, currentPage, count);
    }

    @ApiOperation(value="根据id获取人口信息", notes="根据id获取人口信息")
    @GetMapping("/queryById")
    public ServiceResponse<ResidentInfoResponse> queryById(@RequestParam("id")Long id) {
        return ServiceResponse.success(residentInfoService.queryById(id));
    }

    @ApiOperation(value="插入一条测试数据", notes="仅用来MOCK测试数据")
    @GetMapping("/insertOneRecord")
    public ServiceResponse<Integer> insertOneRecord(@ModelAttribute ResidentInfo residentInfo) {
        return ServiceResponse.success(residentInfoService.insert(residentInfo));
    }
}
