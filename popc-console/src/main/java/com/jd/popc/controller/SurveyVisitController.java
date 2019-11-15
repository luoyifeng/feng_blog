package com.jd.popc.controller;

import com.google.common.collect.Lists;
import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.annotation.SurveyVisitAnno;
import com.jd.popc.service.utils.CommonUtils;
import com.jd.service.houseinfo.model.ResidentsInfoResponse;
import com.jd.service.surveyvisit.domain.AbnormalInfo;
import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.AbnormalInfoRequest;
import com.jd.service.surveyvisit.model.CheckFormResponse;
import com.jd.service.surveyvisit.model.CheckResultResponse;
import com.jd.service.surveyvisit.service.AbnormalInfoService;
import com.jd.service.surveyvisit.service.VisitCheckService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangsong on 2018/11/29.
 */
@Api(tags = "调查走访管理", description = "SurveyVisitController")
@SurveyVisitAnno
@RestController
@Slf4j
@RequestMapping("/survey/visit")
public class SurveyVisitController extends BaseController {

    @Autowired
    private AbnormalInfoService abnormalInfoService;
    @Autowired
    private VisitCheckService visitCheckService;
    @Autowired
    private CommonUtils commonUtils;

    @ApiOperation(value="根据条件获取未处理异常信息列表", notes="根据条件获取未处理异常信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "未处理异常列表信息查询成功")
    })
    @GetMapping("/queryByCondition")
    public ServiceResponse<List<AbnormalInfo>> queryByCondition(@ModelAttribute AbnormalInfoRequest abnormalInfoVo) {
        if (StringUtils.isNotEmpty(abnormalInfoVo.getHouseSpecialMark())) {
            if (abnormalInfoVo.getHouseSpecialMark().equals("无")) {
                abnormalInfoVo.setHouseSpecialMark("无");
                abnormalInfoVo.setHouseSpecialMarkList(null);
            } else {
                abnormalInfoVo.setHouseSpecialMarkList(Arrays.asList(abnormalInfoVo.getHouseSpecialMark().split(",", -1)));
            }
        }
        return abnormalInfoService.queryAbnormalInfos(abnormalInfoVo);
    }

    @ApiOperation(value="MOCK测试数据之用，请忽略该方法", notes="MOCK测试数据之用，请忽略该方法")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "新入一条记录成功")
    })
    @PostMapping("/insertOneRecord")
    public ServiceResponse insertOneRecord(@ModelAttribute AbnormalInfo abnormalInfo) {
        abnormalInfoService.insert(abnormalInfo);
        return ServiceResponse.successResponse();
    }

    @ApiOperation(value="保存走访核实单信息", notes="保存走访核实单信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "走访核实单信息保存成功")
    })
    @PostMapping("/check/form/save")
    public ServiceResponse saveVisitCheckForm(@RequestBody @ApiParam(name = "checkFormResponse", value = "待保存的走访核实单信息", required = true) CheckFormResponse checkFormResponse) {
        try {
            // 入住人员过滤
            List<ResidentsInfoResponse> residentsInfoList = checkFormResponse.getResidentsInfo();
            if (residentsInfoList != null && residentsInfoList.size() != 0) {
                List<ResidentsInfoResponse> residentsInfoListNew = residentsInfoList.stream().map(residentsInfo -> {
                    if (StringUtils.isNotEmpty(residentsInfo.getName()) || StringUtils.isNotEmpty(residentsInfo.getRelation())
                            || StringUtils.isNotEmpty(residentsInfo.getSex()) || StringUtils.isNotEmpty(residentsInfo.getNation())
                            || StringUtils.isNotEmpty(residentsInfo.getIdNumber()) || StringUtils.isNotEmpty(residentsInfo.getPermanentAddress())
                            || StringUtils.isNotEmpty(residentsInfo.getOutflow()) || StringUtils.isNotEmpty(residentsInfo.getOutflowInfo())) {
                        return residentsInfo;
                    }
                    return null;
                }).collect(Collectors.toList());
                checkFormResponse.setResidentsInfo(residentsInfoListNew);
            }
            if(checkFormResponse.getAbnormalInfoId() == null) {
                log.error("保存走访核实单信息失败，缺失处理异常信息ID");
                return ServiceResponse.failureResponse();
            }

            visitCheckService.saveVisitCheckForm(checkFormResponse);
        } catch (Exception e) {
            log.error("保存走访核实单信息失败", e);
            return ServiceResponse.failureResponse();
        }

        return ServiceResponse.successResponse();
    }

    @ApiOperation(value="查询该房屋最近一条走访核实单信息", notes="查询该房屋最近一条走访核实单信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询该房屋最近一条走访核实单信息成功")
    })
    @GetMapping("/check/form/queryLastFeedbackByProCollId")
    public ServiceResponse<CheckFormResponse> queryLastFeedbackById(@RequestParam("proCollId") Long proCollId) {
        CheckFormResponse checkFormResponse = visitCheckService.queryLastFeedbackById(proCollId, false, 0);
        if(checkFormResponse == null) {
            return ServiceResponse.success(new CheckFormResponse());
        }

        return ServiceResponse.success(checkFormResponse);
    }

    @ApiOperation(value="已处理异常--结果查询", notes="已处理异常--结果查询")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "已处理异常--结果查询")
    })
    @GetMapping("/check/form/queryFeedbackResultByProCollId")
    public ServiceResponse<CheckResultResponse> queryFeedbackResultByProCollId(@RequestParam("proCollId") Long proCollId) {
        CheckResultResponse checkFormResponse = visitCheckService.queryFeedbackResultByProCollId(proCollId);
        if(checkFormResponse == null) {
            return ServiceResponse.success(new CheckResultResponse());
        }

        return ServiceResponse.success(checkFormResponse);
    }

    @ApiOperation(value="确认核实单信息", notes="确认核实单信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "确认核实单信息成功")
    })
    @PostMapping("/checkSurveyResultById")
    public ServiceResponse<Integer> checkSurveyResultById(@RequestBody CheckForm checkForm) {
        // 修改房屋特殊标签
        String houseSpecialMark = checkForm.getHouseSpecialMark();
        if (StringUtils.isNotEmpty(houseSpecialMark)) {
            ArrayList<String> markList = new ArrayList<>();
            String[] split = houseSpecialMark.split(",", -1);
            for (String mark : split) {
                if (StringUtils.isNotEmpty(mark) && !markList.contains(mark)) {
                    markList.add(mark);
                }
            }
            if (!markList.isEmpty()) {
                String join = StringUtils.join(markList, ',');
                checkForm.setHouseSpecialMark(join);
            }
        }
        return ServiceResponse.success(visitCheckService.checkSurveyResultById(checkForm));
    }

    @ApiOperation(value="打印核实单信息", notes="打印核实单信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "打印核实单信息成功")
    })
    @GetMapping("/check/form/print")
    public void printCheckForm(HttpServletResponse response, @RequestParam("proCollId")Long proCollId) {
        XWPFDocument document = new XWPFDocument();
        OutputStream out = null;
        try {
            CheckFormResponse surveyForm = visitCheckService.queryLastFeedbackById(proCollId, false, 0);
            if(surveyForm == null) {
                surveyForm = new CheckFormResponse();
                surveyForm.setCheckPersons(Lists.newArrayList());
                surveyForm.setVisitPersons(Lists.newArrayList());
            }

            if(surveyForm.getCheckPersons() == null || surveyForm.getVisitPersons() == null) {
                surveyForm.setCheckPersons(Lists.newArrayList());
                surveyForm.setVisitPersons(Lists.newArrayList());
            }

            //generate document title
            XWPFParagraph titleParagraph = document.createParagraph();
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setText("调查走访核实单");
            titleRun.setTextPosition(35);
            titleRun.setBold(true);
            titleRun.setFontSize(12);
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);
            titleParagraph.setStyle("标题 3");


            //create table
            XWPFTable table = document.createTable();

            //去掉表格的框线
            CTTblPr tblpro = table.getCTTbl().getTblPr();
            CTTblBorders borders = tblpro.addNewTblBorders();
            borders.addNewBottom().setVal(STBorder.NIL);
            borders.addNewLeft().setVal(STBorder.NIL);
            borders.addNewRight().setVal(STBorder.NIL);
            borders.addNewTop().setVal(STBorder.NIL);
            //also inner borders
            borders.addNewInsideH().setVal(STBorder.NIL);
            borders.addNewInsideV().setVal(STBorder.NIL);

            widthCellsAcrossRow(table, 0, 0, 2000);

            //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            //设置行高
            CTTrPr ctTrPr = table.getRow(0).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            XWPFTableCell tableRowOneCell = tableRowOne.getCell(0);
            tableRowOneCell.setText("房屋信息");
            tableRowOneCell.setColor("E4E4E4");
//            tableRowOneCell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            tableRowOneCell.getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            tableRowOne.addNewTableCell().setText(StringUtils.trimToEmpty(surveyForm.getHouseInfo()));
            tableRowOne.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            //create second row
            XWPFTableRow tableRowTwo = table.createRow();
            ctTrPr = table.getRow(1).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            tableRowTwo.getCell(0).setText("房主信息");
            tableRowTwo.getCell(0).setColor("E4E4E4");
            tableRowTwo.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            tableRowTwo.getCell(1).setText(StringUtils.trimToEmpty(surveyForm.getHouseLandlordInfo()));
            tableRowTwo.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            //create third row
            XWPFTableRow tableRowThree = table.createRow();
            ctTrPr = table.getRow(2).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            tableRowThree.getCell(0).setText("入住人员信息");
            tableRowThree.getCell(0).setColor("E4E4E4");
            tableRowThree.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            tableRowThree.getCell(1).setText(StringUtils.trimToEmpty(surveyForm.getHouseResidentInfo()));
            tableRowThree.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            XWPFTableRow visitReasonRow = table.createRow();
            ctTrPr = table.getRow(3).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            visitReasonRow.getCell(0).setText("走访原因");
            visitReasonRow.getCell(0).setColor("E4E4E4");
            visitReasonRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            visitReasonRow.getCell(1).setText(StringUtils.trimToEmpty(surveyForm.getVisitReason()));
            visitReasonRow.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            XWPFTableRow checkPersonRow = table.createRow();
            ctTrPr = table.getRow(4).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            checkPersonRow.getCell(0).setText("核实人员");
            checkPersonRow.getCell(0).setColor("E4E4E4");
            checkPersonRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            checkPersonRow.getCell(1).setText(surveyForm.getCheckPersons().stream().map(c -> {
                if(c != null && c.getName() != null) {
                    return StringUtils.trimToEmpty(c.getName()) + "，" + StringUtils.trimToEmpty(c.getContactInfo());
                }
                return "";
            }).collect(Collectors.joining("；")));
            checkPersonRow.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            XWPFTableRow visitPersonRow = table.createRow();
            ctTrPr = table.getRow(5).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(360));
            visitPersonRow.getCell(0).setText("走访人员");
            visitPersonRow.getCell(0).setColor("E4E4E4");
            visitPersonRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            visitPersonRow.getCell(1).setText(surveyForm.getVisitPersons().stream().collect(Collectors.joining("，")));
            visitPersonRow.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);

            XWPFTableRow checkResultRow = table.createRow();
            ctTrPr = table.getRow(6).getCtRow().addNewTrPr();
            ctTrPr.addNewTrHeight().setVal(BigInteger.valueOf(2000));
            checkResultRow.getCell(0).setText("核实结果");
            checkResultRow.getCell(0).setColor("E4E4E4");
            checkResultRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.RIGHT);
            checkResultRow.getCell(1).setText("口 寄住人员：         口 房屋出租：         口 其他：     ");
            checkResultRow.getCell(1).getParagraphs().get(0).setIndentFromLeft(200);
            checkResultRow.getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
            /*XWPFParagraph xwpfParagraph1 = checkResultRow.getCell(1).addParagraph();
            XWPFRun run1 = xwpfParagraph1.createRun();
            run1.setText("口 房屋出租：       ");
            checkResultRow.getCell(1).getParagraphs().get(1).setIndentFromLeft(200);

            XWPFParagraph xwpfParagraph2 = checkResultRow.getCell(1).addParagraph();
            XWPFRun run2 = xwpfParagraph2.createRun();
            run2.setText("口 其他：     ");
            checkResultRow.getCell(1).getParagraphs().get(2).setIndentFromLeft(200);*/

            out = response.getOutputStream();
            response.reset();
            response.setContentType("application/x-msdownloadoctet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=survey-form.docx");
            document.write(out);
        } catch (IOException e) {
            log.error("download check survey form fail,", e);
        } finally {
            if(out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {

                }
            }
        }

        log.info("download check survey form success:{}", proCollId);
    }

    /**
     * 获取案底情况
     * @param idCardNum
     * @return
     */
    @GetMapping("/check/form/getCaseBackGround")
    public ServiceResponse<String> getCaseBackGround(@RequestParam("idCardNum") String idCardNum) {
        if (StringUtils.isNotEmpty(idCardNum)) {
            List<String> personTags = commonUtils.getPersonTags(Collections.singletonList(idCardNum));
            return ServiceResponse.success( StringUtils.join(personTags.toArray(), ','));
        }
        return ServiceResponse.failure();
    }

    /**
     * 设置第一列单元格的宽度及内部文字右对齐
     *
     * @param table
     * @param rowNum
     * @param colNum
     * @param width
     */
    private static void widthCellsAcrossRow(XWPFTable table, int rowNum, int colNum, int width) {
        XWPFTableCell cell = table.getRow(rowNum).getCell(colNum);
        if (cell.getCTTc().getTcPr() == null) {
            cell.getCTTc().addNewTcPr();
        }
        if (cell.getCTTc().getTcPr().getTcW() == null) {
            cell.getCTTc().getTcPr().addNewTcW();
        }
        //设置第一列的单元格宽度
        cell.getCTTc().getTcPr().getTcW().setW(BigInteger.valueOf((long) width));
        cell.getCTTc().getTcPr().getTcW().setType(STTblWidth.DXA);

//        CTVerticalJc ctVerticalJc = cell.getCTTc().getTcPr().addNewVAlign();
//        ctVerticalJc.setVal(STVerticalJc.CENTER);
    }
}
