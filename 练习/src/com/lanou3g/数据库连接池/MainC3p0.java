package com.lanou3g.数据库连接池;

import com.lanou3g.数据库连接池.bean.StudentBean;
import com.lanou3g.数据库连接池.common.UnderlineProcessor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


public class MainC3p0 {
    public static void main(String[] args) throws Exception {
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = source.getConnection();

        String sql = "select * from t_students where stu_gender = ?";
        QueryRunner runner = new QueryRunner();

        List<StudentBean> query = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()), "男");
        query.forEach(System.out::println);
    }
}
