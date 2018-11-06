package com.lanou3g.db;

import com.lanou3g.common.ConnectionSource;
import com.lanou3g.common.UnderlineProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanouRunner {

    //防止多次创建连接
//    private static  LanouDataSource source = new LanouDataSource();

//    private static final ComboPooledDataSource SOURCE;
//    private static  DataSource ds;

    private static ConnectionSource source;


    public static void setSource(ConnectionSource source) {
        LanouRunner.source = source;
    }

    private static void check() {
        if (source == null) {
            throw new RuntimeException("请先为Source对象赋值");
        }
    }


    private LanouRunner() {
    }

//    static {
//        try {
//            Properties prop = new Properties();
//            prop.load(new FileReader("src/JDBC.properties"));
//            ds = BasicDataSourceFactory.createDataSource(prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//            ds = null;
//        }

    //加载驱动
//        LanouDataSource.loadDriver("com.mysql.cj.jdbc.Driver");
//        SOURCE = new ComboPooledDataSource();
//        try {
//            SOURCE.setDriverClass("com.mysql.jdbc.Driver");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        SOURCE.setJdbcUrl("jdbc:mysql://localhost:3306/my_db");
//        SOURCE.setUser("root");
//        SOURCE.setPassword("123456");
//        SOURCE.setInitialPoolSize(3);
//        SOURCE.setMaxPoolSize(6);
//        SOURCE.setMaxIdleTime(1000);
//
//    }

    public static <T> List<T> findAll(String sql, Class<T> clazz, Object... params) {
        check();
//        Connection conn = LanouDataSource.getInstance().getConnection();
        try {
            Connection conn = source.get();
            QueryRunner runner = new QueryRunner();
            List<T> query = runner.query(conn, sql, new BeanListHandler<>(clazz, new UnderlineProcessor()), params);
            //连接使用完之后 释放连接
//            LanouDataSource.getInstance().release(conn);
            conn.close();
            return query;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        //为了防止其他人调用该方法会获取到空对象
        //返回一个0  size 的集合
        return new ArrayList<>();
    }
}
