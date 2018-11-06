package com.lanou3g.数据库连接池;

import com.lanou3g.数据库连接池.bean.StudentBean;
import com.lanou3g.数据库连接池.common.C3p0DataSource;
import com.lanou3g.数据库连接池.common.DBCPDataSource;
import com.lanou3g.数据库连接池.common.UnderlineProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
//        C3p0DataSource source = new C3p0DataSource();
//        Connection conn = source.get();
        DBCPDataSource source1 = new DBCPDataSource();
        Connection conn = source1.get();
        String sql = "select * from t_students where stu_gender = ?";
        QueryRunner runner = new QueryRunner();
        List<StudentBean> query = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()),"男");
        query.forEach(System.out::println);
    }
}
