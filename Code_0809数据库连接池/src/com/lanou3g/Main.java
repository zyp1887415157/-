package com.lanou3g;

import com.lanou3g.bean.StudentBean;
import com.lanou3g.common.C3p0DataSource;
import com.lanou3g.common.CustomDataSource;
import com.lanou3g.common.DBCPDataSource;
import com.lanou3g.db.LanouRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        //配置连接池
//        LanouRunner.setSource(new C3p0DataSource());
        LanouRunner.setSource(new DBCPDataSource());
//        LanouRunner.setSource(new CustomDataSource());
        for (int i = 0; i < 8; i++) {
            String sql = "select * from t_students where stu_gender = ?";
            List<StudentBean> list = LanouRunner.findAll(sql, StudentBean.class, "男");
            list.forEach(System.out::println);
            System.out.println("========"+i+"=============");
        }




    }
}
