package com.lanou3g.config;

//数据库配置接口
public final class DatabaseConfig {
    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    //构造方法私有化  不让别人调用
    private DatabaseConfig(){};
}
