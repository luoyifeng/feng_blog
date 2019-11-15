package com.jd.popc.wateruse;

import com.jd.service.wateruse.domain.WaterUseInfo;
import com.jd.service.wateruse.model.WaterUseInfoRequest;
import com.jd.service.wateruse.service.WaterUseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;
import java.util.Date;

/**
 * @author yangsong on 2018/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@Slf4j
public class WaterUseInfoTest {

    @Autowired
    private WaterUseInfoService waterUseInfoService;

    @Test
    public void queryByConditionTest() {
        WaterUseInfoRequest waterUseInfo = new WaterUseInfoRequest();
//        waterUseInfo.setId(1L);
        waterUseInfo.setHouseStatus("出租");
        waterUseInfo.setHouseWaterStatus("异常");
//        waterUseInfoService.queryByCondition(waterUseInfo);
        String str = "abc";
        str += "def";
        System.out.println(str);
    }

    @Test
    public void insertOneRecordTest() {
        WaterUseInfo waterUseInfo = new WaterUseInfo();
        waterUseInfo.setProCollId(1L);
        waterUseInfo.setCommunityName("沁园春小区");
        waterUseInfo.setCommunityDistrict("东城区");
        waterUseInfo.setHouseUnit("3单元201");
        waterUseInfo.setApartmentNum("2号楼");
        waterUseInfo.setHouseStatus("出租");
        waterUseInfo.setLandlordName("张理");
        waterUseInfo.setLandlordId("110389197009200989");
        waterUseInfo.setLandlordPhone("15076898764");
        waterUseInfo.setPreviousWaterConsumption("8");
        waterUseInfo.setCurrentWaterConsumption("9.12");
        waterUseInfo.setAvgWaterConsumption("13");
        waterUseInfo.setMonthOnMonthGrowth("114%");
//        waterUseInfo.setYearStandardDeviation("0.75");
//        waterUseInfo.setQuartile("<25%");
        waterUseInfo.setCoefficientVariation("12.3");
        waterUseInfo.setHouseWaterStatus("正常");
        waterUseInfo.setCreateTime(new Date());
        waterUseInfo.setUpdateTime(new Date());
        waterUseInfo.setDt("20181204");
        waterUseInfo.setOfficerNo("001");

//        int insertNo = waterUseInfoService.insert(waterUseInfo);
        log.info("新入一条记录后生成的编号: {}", waterUseInfo.getId());
    }

    @Test
    public void messageFormatTest() {
        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();

        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);

        //最后格式化并输出
        System.out.println("百分数：" + nt.format(0.98765));
    }
}
