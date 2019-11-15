package com.jd.service.summary.model;

import java.util.List;

import com.jd.service.houseinfo.domain.HouseQueryInfo;
import com.jd.service.surveyvisit.domain.AbnormalInfo;

import lombok.Data;

/**
 * @author yangsong on 2019/2/27.
 */
@Data
public class TotalSummary {
    private String label;
    private Integer number;
    private List<AbnormalInfo> allData;
    private List hData;
}
