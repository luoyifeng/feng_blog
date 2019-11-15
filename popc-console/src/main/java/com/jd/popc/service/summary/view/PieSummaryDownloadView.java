package com.jd.popc.service.summary.view;

import com.jd.service.summary.model.PieDetails;
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
public class PieSummaryDownloadView extends AbstractCsvView {

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {

    	TotalSummaryRequest totalSummaryRequest = (TotalSummaryRequest) model.get("requestParam");

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"xiaoqurenkoutongji.csv\"");
        response.setContentType("application/ms-excel; charset=utf-8");
        response.setCharacterEncoding("GBK");

        CsvListWriter csvWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        List<String> header = new ArrayList<>();

        //Prepared HEADER
        log.info("write header");
        header.add("小区名称");
        header.add("负责民警");
        header.add("人口总数");
        header.add("常住人口");
        header.add("暂住人口");
        header.add("寄住人口");
        header.add("其他人口");
        csvWriter.writeHeader(header.toArray(new String[]{}));

        //获取数据
        List<PieDetails> pieList=totalSummaryRequest.getPieList();
        List<Object> content = new ArrayList<>();
        for(PieDetails pie : pieList) {
        	content.add(pie.getCommunityName());
        	content.add(pie.getOfficer());
        	content.add(pie.getTodayNumber()+pie.getTodayNumber2()+pie.getTodayNumber3()+pie.getTodayNumber4());
        	content.add(pie.getTodayNumber());
        	content.add(pie.getTodayNumber2());
        	content.add(pie.getTodayNumber3());
        	content.add(pie.getTodayNumber4());
        	csvWriter.write(content);
        }
        csvWriter.close();
    }
}