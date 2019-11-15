package com.jd.popc.service.summary.view;

import com.jd.service.summary.model.HouseDetails;
import com.jd.service.summary.model.TotalSummaryRequest;
import lombok.extern.slf4j.Slf4j;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HouseSummaryDownloadView extends AbstractCsvView {

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {
    	TotalSummaryRequest totalSummaryRequest = (TotalSummaryRequest) model.get("requestParam");

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"xiaoqufangwutongji.csv\"");
        response.setContentType("application/ms-excel; charset=utf-8");
        response.setCharacterEncoding("GBK");

        CsvListWriter csvWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        List<String> header = new ArrayList<>();

        //Prepared HEADER
        log.info("write header");
        header.add("小区名称");
        header.add("负责民警");
        header.add("房屋总数");
        header.add("房屋自住套数");
        header.add("房屋出租套数");
        header.add("房屋空置套数");
        header.add("房屋待核套数");
        csvWriter.writeHeader(header.toArray(new String[]{}));

        //获取数据
        List<HouseDetails> houseList=totalSummaryRequest.getHouseList();
        List<Object> content = new ArrayList<>();
        for(HouseDetails house : houseList) {
        	content.add(house.getCommunityName());
        	content.add(house.getOfficer());
        	content.add(house.getTotal());
        	content.add(house.getSelf());
        	content.add(house.getRent());
        	content.add(house.getEmpty());
        	content.add(house.getTodo());
        	csvWriter.write(content);
        }
        csvWriter.close();
    }
}