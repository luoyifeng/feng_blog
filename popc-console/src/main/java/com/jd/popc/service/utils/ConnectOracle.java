
package com.jd.popc.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:luoyifeng
 **/
@Slf4j
public class ConnectOracle {
    private static Connection conn = null;
//    private static String driver = "oracle.jdbc.OracleDriver";
//    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//    private static String userName = "system";
//    private static String password = "123456";
    private static String driver = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@//10.38.6.223:1521/orcl";
    private static String userName = "sq_jzzd";
    private static String password = "123";

    private static synchronized Connection getConn() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName, password);
            } catch (Exception e) {
                log.error("oracle连接失败");
                e.printStackTrace();
            }

        }
        return conn;
    }

    /**
     * 查询重点人员及风险人员
     * @param id
     * @return
     */
    public static ArrayList<String> queryKeyOrRisk(String id) {
        PreparedStatement pstmt;
        String result = null;
        ArrayList<String> strings = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            String sql = "select FL from SQ_QB.RY_14N_ZDRYGLXX where YXX=1 AND GMSFHM='" + id + "'";
            log.info("orcale连接开始 sql :" + sql);
            pstmt = getConn().prepareStatement(sql, ResultSet.CONCUR_READ_ONLY);
//            pstmt = getConn().prepareStatement("select name from EMP where name='" + id + "'", ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            log.info("orcale连接完成");
            while (rs.next()) {
                result = rs.getString("FL");
                if (StringUtils.isNotEmpty(result)) {
                    strings.add(result);
                }
            }
        } catch (Exception e) {
            log.error("oracle 查询失败");
            e.printStackTrace();
        } finally {
            close(con, pstm, rs);
        }
        return strings;
//        return getTest();
    }

    /**
     * 查询涉案人员
     * @param id
     * @return
     */
    public static List<String> queryInvolved(String id) {
        PreparedStatement pstmt;
        String result = null;
        ArrayList<String> strings = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            String sql = "select GMSFHM from SQ_JWPT.AJ_JWPT_XYRXX where GMSFHM='" + id + "'";
            log.info("orcale连接开始 sql :" + sql);
            con = getConn();
            pstmt = con.prepareStatement(sql, ResultSet.CONCUR_READ_ONLY);
//            pstmt = getConn().prepareStatement("select name from EMP where name='" + id + "'", ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            log.info("orcale连接完成");
            while (rs.next()) {
                result = rs.getString("GMSFHM");
                if (StringUtils.isNotEmpty(result)) {
                    strings.add(result);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            log.error("连接失败");
        } finally {
            close(con, pstm, rs);
        }
        return strings;
    }



    /**
     * 查询重点人员和风险人员
     * @param id
     * @return
     */
    public static Map queryZdryglxxById(String id) {
        HashMap<String, String> m = new HashMap<>();
        // 重点风险
        ArrayList<String> keyOrRisks = queryKeyOrRisk(id);
        if (keyOrRisks.size() == 0) {
            for (String tag : keyOrRisks) {
                m.put("FL", tag);
            }
        }

        // 涉案人员
        List<String> involved = queryInvolved(id);
        if (involved.size() == 0) {
            for (String tag : keyOrRisks) {
                m.put("SA", tag);
            }
        }
        return m;
    }

    /**
     * 查询重点人员和风险人员 批量查询
     * @param ids
     * @return
     */
    public static List<Map> queryZdryglxxByIds (List<String> ids) {
        List<Map> lists = new ArrayList<>();
        if (ids == null || ids.size() == 0) {
            HashMap<String, String> m = new HashMap<>();
            lists.add(m);
            return lists;
        }

        for (String id : ids) {
            HashMap<String, String> mOne = new HashMap<>();
            mOne.put("GMSFHM" , id);
            // 重点风险
            ArrayList<String> keyOrRisks = queryKeyOrRisk(id);
            if (keyOrRisks.size() == 0) {
                for (String tag : keyOrRisks) {
                    mOne.put("FL", tag);
                }
            }

            // 涉案人员
            List<String> involved = queryInvolved(id);
            if (involved.size() == 0) {
                for (String tag : keyOrRisks) {
                    mOne.put("SA", tag);
                }
            }

            lists.add(mOne);
        }
        return lists;
    }

    private static ArrayList<String> getTest() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("重点人员");
        return strings;
    }

    public static void close(Connection con, Statement pstm, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 关闭执行通道
        if(pstm !=null) {
            try {
                pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 关闭连接通道
        try {
            if(con != null &&(!con.isClosed())) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
