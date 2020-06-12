package cn.zedongw.jquerystuding.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JdbcUtils
 * @Description: 自定义数据库连接工具
 * @Author ZeDongW
 * @Date 2020/6/12 0012 21:59
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class JdbcUtils {
    /**
     * 数据库连接参数
     */
    private static String DRIVER = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;

    /**
     * 数据库连接对象
     */
    private static Connection conn;

    /**
     * Description: 从数据库配置文件读取参数注册驱动
     * @methodName: static initializer
     * @param null 1
     * @throws
     * @return: '
     * @author: ZeDongW
     * @date: 2020/6/12 0012 22:16
     */
    static{
        try {
            Properties property = new Properties();
            property.load(JdbcUtils.class.getResourceAsStream("/jdbc.properties"));
            DRIVER=property.getProperty("DRIVER");
            URL=property.getProperty("URL");
            USERNAME=property.getProperty("USERNAME");
            PASSWORD=property.getProperty("PASSWORD");
            Class.forName(DRIVER);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void dbClose(Connection conn, Statement stmt, ResultSet resul){
        if (resul != null){
            try {
                resul.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
