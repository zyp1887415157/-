package com.lanou3g.JDBC.config;

public class DatabaseConfig {

    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/my_db";
    public static final String ROOT = "root";
    public static final String PASSWORD = "123456";

    //构造方法私有化  不让别人调用
    private DatabaseConfig(){};
}
