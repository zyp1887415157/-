package com.lanou3g.JDBC.utils;

import com.lanou3g.JDBC.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;


public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    DatabaseConfig.URL_MYSQL,
                    DatabaseConfig.ROOT,
                    DatabaseConfig.PASSWORD
            );
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> execute(String sql, ResultHandler<T> r) {
        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            List<T> goods = r.handle(statement, sql);
            statement.close();
            conn.close();
            return goods;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeAll(conn, statement);
        }
        return null;
    }

}
