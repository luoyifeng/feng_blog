package com.jd.popc.service.shoppinginfo;
import java.util.*;

import com.jd.com.base.response.ServiceResponse;
import com.jd.popc.mapper.*;
import com.jd.popc.mapper.mysql.*;
import com.jd.service.shoppinginfo.domain.LogisticsSocietyInfo;
import com.jd.service.shoppinginfo.domain.ShoppingInfo;
import com.jd.service.shoppinginfo.domain.ShoppingInfoVo;
import com.jd.service.shoppinginfo.domain.ShoppingSocietyInfo;
import com.jd.service.shoppinginfo.service.ShoppingInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author:luoyifeng
 **/
@Slf4j
@Service
public class ShoppingInfoServiceImpl implements ShoppingInfoService {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    @Resource
    private WaterUseInfoMapper waterUseInfoMapper;
    @Resource
    private CheckListMapper checkListMapper;
    @Resource
    private HouseBasicInfoMapper houseBasicInfoMapper;
    @Resource
    private AbnormalInfoMapper abnormalInfoMapper;
    @Resource
    private ShoppingSocietyInfoMapper shoppingSocietyInfoMapper;
    @Resource
    private LogisticsSocietyInfoMapper logisticsSocietyInfoMapper;
//    @Value("${community.name}")
    private String communityNames = "万豪新城,东城美域,东城阳光名都,东方花园,九龙花园,众大上海城,千秋时代新城,卧龙湾,名仕嘉园," +
        "名河雅居,天一苑,宏成都市花园,宿豫商贸城,尚东一号,帝景豪苑,御景龙庭,惠隆花园,文昌花园,新城市花园,新新家园,新达公寓,星海湾," +
        "朝晖公寓,桃李苑,水润天城,江山一品,江山国际花园,浦东国际花园,珠江花园,盛世家园,豫江大厦,豫苑小区,郡王府,都市晨光,金外滩," +
        "金色威尼斯,金色家园,金融财富广场,钻石公寓,锦华名园,锦华御园,锦泰花园,锦绣江南,阳光一百,雨露小区,香缇河畔,黄山佳园,鼎创新天地," +
        "星河绿洲,国际购物公园,豫景山庄,小香港";

    @Override
    public ServiceResponse uploadShoppingFile(InputStream file) {
        try {
            InputStreamReader is = new InputStreamReader(file);
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line = null;
            ArrayList<ShoppingInfoVo> shoppingInfos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("\t", -1);
                // 转化为实体类
                ShoppingInfoVo shoppingInfoVo = new ShoppingInfoVo();
                shoppingInfoVo.setOrderId(item[0]);
                shoppingInfoVo.setUserAccount(item[1]);
                shoppingInfoVo.setOrderTime(sdf.parse(item[2]));
                shoppingInfoVo.setOrderIp(item[3]);
                shoppingInfoVo.setOrderPort(item[4]);
                shoppingInfoVo.setGoodsName(item[5]);
                shoppingInfoVo.setReceiverName(item[6]);
                shoppingInfoVo.setReceiverPhone(item[7]);
                shoppingInfoVo.setReceiverAddress(item[8]);
                shoppingInfoVo.setDeliverId(item[9]);
                shoppingInfoVo.setExpName(item[10]);
                shoppingInfoVo.setProvinceName(item[11]);
                shoppingInfoVo.setCityName(item[12]);
                shoppingInfoVo.setCountyName(item[13]);

                String communityName = dataFilterByCommunityName(shoppingInfoVo);
                // 数据清洗
                if (communityName == null) {
                    continue;
                }

                // 大小写转换 地址分词
                String[] split = shoppingInfoVo.getReceiverAddress().split(communityName, -1);
                if (split != null && split.length == 2) {
                    dataConvert(shoppingInfoVo, split[1]);
                }
                // 如果地址中有空的话则需要根据电话和小区名匹配房屋总id
                Long proCollId = null;
                if (StringUtils.isEmpty(shoppingInfoVo.getApartmentNum()) || StringUtils.isEmpty(shoppingInfoVo.getCommunityName())
                        || StringUtils.isEmpty(shoppingInfoVo.getHouseUnit()) || StringUtils.isEmpty(shoppingInfoVo.getRoomNum())) {
                    // 根据调查走访表获取获取房屋总id
                    HashMap<String, String> map = new HashMap<>();
                    map.put("communityName", shoppingInfoVo.getCommunityName());
                    map.put("phone", shoppingInfoVo.getReceiverPhone());

                    List<Long> proCollIdsByCheck = checkListMapper.queryBycommunityNameAndPhone(map);
                    if (proCollIdsByCheck.size() == 0) {
                        List<Long> proCollIdByHouseBasic = houseBasicInfoMapper.queryBycommunityNameAndPhone(map);
                        if (proCollIdByHouseBasic.size() > 0) {
                            proCollId = proCollIdByHouseBasic.get(0);
                        }
                    } else {
                        proCollId = proCollIdsByCheck.get(0);
                    }
                } else {
                    Long proCollIdByWater = waterUseInfoMapper.selectProCollIdByAddress(shoppingInfoVo);
                    proCollId = proCollIdByWater;
                }
                if (proCollId != null) {
                    shoppingInfoVo.setProCollId(proCollId);
                    //更新 用水数据表和走访信息表
                    waterUseInfoMapper.updateShoppingTime(shoppingInfoVo);
                    abnormalInfoMapper.updateShoppingTime(shoppingInfoVo);
                }

                ShoppingInfo shoppingInfo = new ShoppingInfo();
                try {
                    BeanUtils.copyProperties(shoppingInfo, shoppingInfoVo);
                } catch (Exception e) {
                    log.error("对象克隆失败，源对象{}， 目的对象", shoppingInfoVo, shoppingInfo);
                }
//                shoppingSocietyInfoMapper.insert(shoppingInfo);
            }
            // 首先
        } catch (IOException e) {
            log.error("购物数据文件解析失败{}", e);
            return ServiceResponse.failure("购物数据文件解析失败");
        } catch (ParseException e) {
            log.error("日期格式解析失败{}", e);
            return ServiceResponse.failure("日期格式解析失败");
        }
        return null;
    }

    @Override
    public List<ShoppingInfo> getShoppingInfoByProCollId(Long proCollId) {
        /*if (proCollId == null) {
            return null;
        }
        List<ShoppingInfo> shoppingInfoList = shoppingInfoMapper.selectByProCollId(proCollId);
        return shoppingInfoList;*/
        return null;
    }

    @Override
    public List<ShoppingSocietyInfo> getShoppingSocietyInfoByProCollId(Long proCollId) {
        List<ShoppingSocietyInfo> shoppingSocietyInfos = shoppingSocietyInfoMapper.selectByProCollId(proCollId);
        return shoppingSocietyInfos;
    }

    @Override
    public List<LogisticsSocietyInfo> getLogisticsSocietyInfoByProCollId(Long proCollId) {
        List<LogisticsSocietyInfo> logisticsSocietyInfos = logisticsSocietyInfoMapper.selectByProCollId(proCollId);
        return logisticsSocietyInfos;
    }

    /**
     * 是否包含指定的小区名
     *
     * @param shoppingInfoVo
     * @return
     */
    private String dataFilterByCommunityName(ShoppingInfoVo shoppingInfoVo) {
        if (StringUtils.isNotEmpty(communityNames)) {
            List<String> communittNameList = Arrays.asList(communityNames.split(",", -1));
            for (String name : communittNameList) {
                if (shoppingInfoVo.getReceiverAddress().contains(name)) {
                    return name;
                }
            }
        }
        return null;
    }

    /**
     * 数据转换
     *
     * @param shoppingInfoVo
     * @return
     */
    private void dataConvert(ShoppingInfoVo shoppingInfoVo, String address) {
        if (StringUtils.isEmpty(address)) {
            return;
        }
        // 数据转化 将中文数字替换
        address.replaceAll("一","1");
        address.replaceAll("二","2");
        address.replaceAll("三","3");
        address.replaceAll("四","4");
        address.replaceAll("五","5");
        address.replaceAll("六","6");
        address.replaceAll("七","7");
        address.replaceAll("八","8");
        address.replaceAll("九","9");
        address.replaceAll("十","10");

        Pattern p = Pattern.compile("(.{1,10}?(?:栋|幢|号楼)){0,1}(.{1,7}?(?:单元)){0,1}([a-zA-Z0-9?(?:室)]{1,10}){0,1}");
        Matcher m = p.matcher(address);
        while(m.find()) {
            if (StringUtils.isNotEmpty(m.group(0))) {
                shoppingInfoVo.setApartmentNum(m.group(1));
                shoppingInfoVo.setHouseUnit(m.group(2));
                shoppingInfoVo.setRoomNum(m.group(3));
            }
        }
    }

    /**
     * 汉字转化为阿拉伯数字
     * @param chineseNumber
     * @return
     */
    private int chineseNumber2Int(String chineseNumber){
        int result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        char[] cnArr = new char[]{'一','二','三','四','五','六','七','八','九'};
        char[] chArr = new char[]{'十','百','千','万','亿'};
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if(0 != count){//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            if(b){//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }
}
