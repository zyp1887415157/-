package com.lanou3g.JDBC2;

import java.sql.Connection;

public class JDBCUtil {
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return null;
    }
}
