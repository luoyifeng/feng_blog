package com.jd.popc.service.wateruse.view;

import com.jd.common.utils.StringUtil;
import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.model.WaterUseInfoRequest;
import com.jd.service.wateruse.service.WaterUseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class WaterUseInfoDownloadView extends AbstractCsvView {

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {


        WaterUseInfoService waterUseInfoService = (WaterUseInfoService) model.get("serviceBean");
        WaterUseInfoRequest waterUseInfoRequest = (WaterUseInfoRequest) model.get("requestParam");

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"fangwuyichang.csv\"");
        response.setContentType("application/ms-excel; charset=utf-8");
        response.setCharacterEncoding("GBK");

        CsvListWriter csvWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        List<String> header = new ArrayList<>();

        //Prepared HEADER
        log.info("write header");
        header.add("小区名称");
        header.add("楼栋名称");
        header.add("房号");
        header.add("房屋状态");
        header.add("房东信息");
        header.add("联系方式");
        header.add("上次用水量");

        header.add("本次用水量");
        header.add("平均用水量");
        header.add("疑似空转租");
        header.add("变异系数");
        header.add("Z分数");
        csvWriter.writeHeader(header.toArray(new String[]{}));

        int page = 1;
        int size = 1000;
        waterUseInfoRequest.setCurrentPage(page);
        waterUseInfoRequest.setOffset(size);

        //先查询出来该分层下所有的店铺ID
        List<WaterUseInfo> waterUseInfoList = waterUseInfoService.queryWaterUseInfos(waterUseInfoRequest).getData();

        while(waterUseInfoList.size() > 0) {
            for(WaterUseInfo waterUserInfo : waterUseInfoList) {
                List<String> content = new ArrayList<>();
                content.add(StringUtil.trimToEmpty(waterUserInfo.getCommunityName()));
                content.add(StringUtil.trimToEmpty(waterUserInfo.getApartmentNum()));
                content.add(waterUserInfo.getRoomNum());
                content.add(waterUserInfo.getHouseStatus());
                content.add(waterUserInfo.getLandlordName() + "-" + waterUserInfo.getLandlordId());
                content.add(StringUtil.trimToEmpty(waterUserInfo.getLandlordPhone()));
                content.add(waterUserInfo.getPreviousWaterConsumption());
                content.add(waterUserInfo.getCurrentWaterConsumption());
                content.add(waterUserInfo.getAvgWaterConsumption());
                content.add(waterUserInfo.getSuspectRent() ? "是" : "否");
                content.add(waterUserInfo.getCoefficientVariation());
                content.add(waterUserInfo.getStandardScore());
                csvWriter.write(content);
            }

            page += 1;

            waterUseInfoRequest.setCurrentPage(page);
            waterUseInfoList = waterUseInfoService.queryWaterUseInfos(waterUseInfoRequest).getData();
        }

        csvWriter.close();
    }
}