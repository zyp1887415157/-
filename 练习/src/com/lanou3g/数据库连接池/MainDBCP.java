package com.lanou3g.数据库连接池;

import com.lanou3g.数据库连接池.bean.StudentBean;
import com.lanou3g.数据库连接池.common.DBCPDataSource;
import com.lanou3g.数据库连接池.common.UnderlineProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class MainDBCP {
    public static void main(String[] args) throws Exception {
      DBCPDataSource source = new DBCPDataSource();
        Connection conn = source.get();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/JDBC.properties"));
        QueryRunner runner = new QueryRunner();
        String sql = "select * from t_students where stu_gender = ?";
        List<StudentBean> query = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()), "女");
        query.forEach(System.out::println);


    }
}
