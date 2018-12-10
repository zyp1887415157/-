package com.lanou.bookstore.user.util;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String URL = "jdbc:mysql://localhost:3306/bookstore";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConn() {
        Connection conn = threadLocal.get();
        if (conn != null) {
            try {
                if (!conn.getAutoCommit()){
                    //如果开启了事务 那么提交事务
                    conn.commit();
                }
                conn.close();
                //把这个conn从threadLocal清除
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void begin(){
        Connection connection=getConn();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {

            Connection conn = threadLocal.get();
            if (conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                threadLocal.set(conn);
            }

            return conn;
        } catch (SQLException e) {
            //直接转化成运行时异常
            throw new RuntimeException(e);
        }
    }
}