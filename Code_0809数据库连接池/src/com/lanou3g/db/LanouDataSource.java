package com.lanou3g.db;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

//用来获取数据库连接
public class LanouDataSource {


    private static class Holder{
        private static final LanouDataSource INSTANCE = new LanouDataSource();
    }

    public static LanouDataSource getInstance(){
        return Holder.INSTANCE;
    }

    //连接池  是一个集合
    private List<Connection> pool = new Vector<>();
    private String url;
    private String use;
    private String password;


    private LanouDataSource() {
        //为了自己使用方便
        url = "jdbc:mysql://localhost:3306/my_db";
        use = "root";
        password = "123456";

        //创建连接  循环5次 放到连接池中
        try {
            for (int i = 0; i < 5; i++) {
                Connection conn = DriverManager.getConnection(url, use, password);
                pool.add(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }

    //获取连接
    public Connection getConnection() {
        //如果连接池中有连接,就取出一个  防止数组越界
        if (pool.size() > 0) {
            return pool.remove(0);
        }
        throw new RuntimeException("连接池中连接数量不够了");
    }

    //用完之后将连接放入到连接池中
    public void release(Connection conn) {
        pool.add(conn);
    }

    //加载驱动
    public static void loadDriver(String driverName) {
        DbUtils.loadDriver(driverName);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
