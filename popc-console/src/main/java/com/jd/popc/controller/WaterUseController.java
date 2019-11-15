package com.jd.popc.controller;

import com.jd.com.base.response.ServiceResponse;
import com.jd.common.utils.NumberUtil;
import com.jd.popc.annotation.WaterUseInfoAnno;
import com.jd.popc.service.wateruse.view.WaterUseInfoDownloadView;
import com.jd.service.shoppinginfo.service.ShoppingInfoService;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.model.ArrayParam;
import com.jd.service.wateruse.model.WaterUseInfoRequest;
import com.jd.service.wateruse.service.WaterUseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yangsong on 2018/11/29.
 */
@Api(tags = "用水异常判断", description = "WaterUseController")
@RestController
@WaterUseInfoAnno
@Slf4j
@RequestMapping("/water/use")
public class WaterUseController extends BaseController {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Value("${local.file.upload.path}")
    private String localPath;

    @Autowired
    private WaterUseInfoService waterUseInfoService;
    @Autowired
    private ShoppingInfoService shoppingInfoService;

    @ApiOperation(value="根据条件获取用水信息列表", notes="根据条件获取用水信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "用水异常列表信息查询成功")
    })
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<WaterUseInfo>> queryByCondition(@ModelAttribute WaterUseInfoRequest request) {
        Integer currentPage = request.getCurrentPage();
        if(currentPage == null) {
            currentPage = 1;
        }
        request.setCurrentPage(currentPage);

        if(StringUtils.trimToNull(request.getCoefficientVariation()) != null) {
            request.setCoefficientVariation(NumberUtil.toDouble("%" + request.getCoefficientVariation()));
        }
        if(StringUtils.trimToNull(request.getMonthOnMonthGrowth()) != null) {
            request.setMonthOnMonthGrowth(NumberUtil.toDouble("%" + request.getMonthOnMonthGrowth()));
        }
        if(StringUtils.trimToNull(request.getStandardScore()) != null) {
            request.setStandardScore(NumberUtil.toDouble("%" + request.getStandardScore()));
        }
        if("全部".equals(request.getHouseWaterStatus())) {
            request.setHouseWaterStatus("");
        }

        if (StringUtils.isNotEmpty(request.getHouseSpecialMark())) {
            if (request.getHouseSpecialMark().equals("无")) {
                request.setHouseSpecialMark("无");
                request.setHouseSpecialMarkList(null);
            } else {
                request.setHouseSpecialMarkList(Arrays.asList(request.getHouseSpecialMark().split(",", -1)));
            }
        }

        return waterUseInfoService.queryWaterUseInfos(request);
    }

    @ApiOperation(value="判定异常", notes="判定异常，将选中的行的id设置到参数ids")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "判定异常成功")
    })
    @PostMapping("/judgeAbnormal")
    public ServiceResponse<Boolean> judgeAbnormal(@RequestBody ArrayParam arrayParam) {
//        String officerNo = getOfficerNoByCookie(request.getCookies(), "officerNo");
        return ServiceResponse.success(waterUseInfoService.judgeAbnormal(arrayParam));
    }

    @GetMapping("/download")
    public ModelAndView download(@ModelAttribute WaterUseInfoRequest request) {
        if(StringUtils.trimToNull(request.getCoefficientVariation()) != null) {
            request.setCoefficientVariation(NumberUtil.toDouble("%" + request.getCoefficientVariation()));
        }
        if(StringUtils.trimToNull(request.getMonthOnMonthGrowth()) != null) {
            request.setMonthOnMonthGrowth(NumberUtil.toDouble("%" + request.getMonthOnMonthGrowth()));
        }
        if(StringUtils.trimToNull(request.getStandardScore()) != null) {
            request.setStandardScore(NumberUtil.toDouble("%" + request.getStandardScore()));
        }
        if("全部".equals(request.getHouseWaterStatus())) {
            request.setHouseWaterStatus("");
        }

        Map<String, Object> model = new HashMap<>(2);
        model.put("serviceBean", waterUseInfoService);
        model.put("requestParam", request);
        return new ModelAndView(new WaterUseInfoDownloadView(), model);
    }

    @RequestMapping(path = "/uploadWaterInfoFile")
    @ResponseBody
    public ServiceResponse<String> uploadWaterInfoFile(@RequestParam("file") MultipartFile file) throws Exception {
//        File localFile = new File(String.format("%s_%s", sdf.format(new Date()), file.getOriginalFilename()));
//        File saveFile = new File(localPath + "/water/" + localFile);
        File localFile = new File(String.format("%s", file.getOriginalFilename()));
        File saveFile = new File(localPath + localFile);
        FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
        return new ServiceResponse<>(saveFile.getCanonicalPath());
    }

    @RequestMapping(path = "/uploadHouseRegisterFile")
    @ResponseBody
    public ServiceResponse<String> uploadHouseRegisterFile(@RequestParam("file") MultipartFile file) throws Exception {
//        File localFile = new File(String.format("%s_%s", sdf.format(new Date()), file.getOriginalFilename()));
//        File saveFile = new File(localPath + "/house/" + localFile);
        File localFile = new File(String.format("%s", file.getOriginalFilename()));
        File saveFile = new File(localPath + localFile);
        FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
        return new ServiceResponse<>(saveFile.getCanonicalPath());
    }

    @RequestMapping(path = "/uploadHouseDealFile")
    @ResponseBody
    public ServiceResponse<String> uploadHouseDealFile(@RequestParam("file") MultipartFile file) throws Exception {
//        File localFile = new File(String.format("%s_%s", sdf.format(new Date()), file.getOriginalFilename()));
//        File saveFile = new File(localPath + "/deal/" + localFile);
        File localFile = new File(String.format("%s", file.getOriginalFilename()));
        File saveFile = new File(localPath + localFile);
        FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
        return new ServiceResponse<>(saveFile.getCanonicalPath());
    }

    /**
     * 上传房屋购物信息
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/uploadHouseShoppingFile")
    @ResponseBody
    public ServiceResponse<String> uploadHouseShoppingFile(@RequestParam("file") MultipartFile file) throws Exception {
        // 判断是否为空
        if (file.isEmpty()) {
            return ServiceResponse.failure("文档为空");
        }
//        ServiceResponse serviceResponse = shoppingInfoService.uploadShoppingFile(file.getInputStream());
//        return serviceResponse;
        return null;
    }

    /**
     * 异常自动判断
     * @return
     */
    @RequestMapping(path = "/judgeAutoAbnormal")
    @ResponseBody
    public ServiceResponse<String> judgeAutoAbnormal() {
        waterUseInfoService.autoJudgeAbnormal();
        return ServiceResponse.success("success");
    }
}
