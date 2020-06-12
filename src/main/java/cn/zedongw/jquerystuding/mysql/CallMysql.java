package cn.zedongw.jquerystuding.mysql;

import cn.zedongw.jquerystuding.utils.JdbcUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @ClassName CallMysql
 * @Description: 调用mysql存储过程和方法
 * @Author ZeDongW
 * @Date 2020/6/12 0012 22:20
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class CallMysql {
    /**
     * 数据库连接对象
     */
    private Connection conn = null;

    private CallableStatement cstmt = null;

    /**
     * Description: 调用mysql存储过程
     * @methodName: callProcedure
     * @param
     * @throws
     * @return: void
     * @author: ZeDongW
     * @date: 2020/6/12 0012 22:56
     */
    public void callProcedure(){
        conn = JdbcUtils.getConnection();

        String sql = "{call proGetCount(?)}";

        try {
            cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            System.out.println(cstmt.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Description: 调用mysql函数
     * @methodName: callFunction
     * @param
     * @throws
     * @return: void
     * @author: ZeDongW
     * @date: 2020/6/12 0012 22:57
     */
    public void callFunction(){
        conn = JdbcUtils.getConnection();

        String sql = "{? = call hello(?)}";

        try {
            cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.setString(2, "张三");
            cstmt.execute();
            System.out.println(cstmt.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
