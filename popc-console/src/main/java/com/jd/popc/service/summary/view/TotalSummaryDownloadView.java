package com.jd.popc.service.summary.view;

import com.jd.service.summary.model.TotalSummary;
import com.jd.service.summary.model.TotalSummaryRequest;
import com.jd.service.summary.service.SystemSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class TotalSummaryDownloadView extends AbstractCsvView {

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {


    	SystemSummaryService summaryService = (SystemSummaryService) model.get("serviceBean");
    	TotalSummaryRequest totalSummaryRequest = (TotalSummaryRequest) model.get("requestParam");

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"xiaoquxinxitongji.csv\"");
        response.setContentType("application/ms-excel; charset=utf-8");
        response.setCharacterEncoding("GBK");

        CsvListWriter csvWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        List<String> header = new ArrayList<>();

        //Prepared HEADER
        log.info("write header");
        header.add("今日判断异常数");
        header.add("总房屋异常数");
        header.add("走访核实数");
        header.add("待访问核实数");
        
        header.add("走访反馈为自住");
        header.add("走访反馈为出租");
        header.add("走访反馈为空置");
        header.add("总走访人数");
        
        header.add("核实常住人口");
        header.add("核实暂住人口");
        header.add("核实寄住人口");
        header.add("核实其他人口");
        csvWriter.writeHeader(header.toArray(new String[]{}));

        //获取汇总数据
        List<TotalSummary> t=summaryService.totalSummary(totalSummaryRequest.getStart(), totalSummaryRequest.getEnd());
        List<TotalSummary> t1=summaryService.houseTotalSummary(totalSummaryRequest.getStart(), totalSummaryRequest.getEnd());
        List<TotalSummary> t2=summaryService.pieTotalSummary(totalSummaryRequest.getStart(), totalSummaryRequest.getEnd());
        
        List<Integer> content = new ArrayList<>();
        for(TotalSummary total : t) {
        	content.add(total.getNumber());
        }
        for(TotalSummary total : t1) {
        	content.add(total.getNumber());
        }
        for(TotalSummary total : t2) {
        	content.add(total.getNumber());
        }
        csvWriter.write(content);
        
        csvWriter.close();
    }
}