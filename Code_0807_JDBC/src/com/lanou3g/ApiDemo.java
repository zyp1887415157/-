package com.lanou3g;

import com.lanou3g.entity.Student;
import com.lanou3g.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        //用来设置事物是否自动提交,默认值为true;
        //为true的时候,每条sql语句都在一个事务中
        connection.setAutoCommit(false);
        //可以预编译sql语句   效率高

        String sql = "select * from t_students where stu_name like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //给sql中的第几个问号设置值为  什么
        statement.setString(1, "孙%");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
//            int id = set.getInt(1);
            String name = set.getString("stu_name");
            System.out.println(name);
        }


        //提交事物
        //connection.commit();
        //回滚事物
        //connection.rollback();
    }
}
