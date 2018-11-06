package com.lanou3g.utils;

import com.lanou3g.config.DatabaseConfig;
import com.lanou3g.entity.Student;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBUtils {


    static {
        //1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

//        第二种方式加载驱动
//      DriverManager.registerDriver(new Driver());
        Properties p = new Properties();
        p.setProperty("user", "root");
        p.setProperty("password", "123456");
        //2.获取连接
        try {
            Connection conn = DriverManager.getConnection(
                    DatabaseConfig.URL_MYSQL,
                    p);
            System.out.println(conn.getClass().getName());
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> execute(String sql, ResultHandler<T> r) {
        //1.获取连接
        Connection conn = getConnection();
        //2.获取statement
        Statement statement = null;
        try {
             statement = conn.createStatement();
            //3.执行sql
            //4.处理结果
            List<T> students = r.handle(statement, sql);
            //5.关闭各种连接
            statement.close();
            conn.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.closeAll(conn,statement);
        }
        return null;
    }

}


