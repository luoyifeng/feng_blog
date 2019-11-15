package com.jd.service.surveyvisit.service;

import com.jd.service.surveyvisit.domain.CheckForm;
import com.jd.service.surveyvisit.model.CheckFormResponse;
import com.jd.service.surveyvisit.model.CheckResultResponse;

import java.util.List;

/**
 * 走访核实单相关处理逻辑
 *
 * @author yangsong on 2018/12/5.
 */
public interface VisitCheckService {

    /**
     * 保存走访核实单信息
     *
     * @param checkFormResponse
     * @return
     */
    int saveVisitCheckForm(CheckFormResponse checkFormResponse);

    /**
     * 根据 app_survey_visit_abnormal_info.id 查询最近一条走访核实信息
     *
     * @param id
     * @param queryAll
     * @return
     */
    CheckFormResponse queryLastFeedbackById(Long id, Boolean queryAll, int auditConfirm);

    /**
     * 反馈结果查询
     * @param proCollId
     * @return
     */
    CheckResultResponse queryFeedbackResultByProCollId(Long proCollId);

    /**
     * 根据 app_survey_visit_abnormal_info.id 查询所有走访核实信息
     *
     * @param id
     * @param queryAll
     * @return
     */
    List<CheckFormResponse> queryAllFeedbackById(Long id, Boolean queryAll);

    /**
     * 确认核实单信息
     *
     * @param checkForm
     * @return
     */
    Integer checkSurveyResultById(CheckForm checkForm);

}
