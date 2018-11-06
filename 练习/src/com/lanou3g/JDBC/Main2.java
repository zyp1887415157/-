package com.lanou3g.JDBC;

import com.lanou3g.JDBC.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main2 {
    public static void main(String[] args) throws Exception {

        Connection connection = DBUtils.getConnection();
        String sql = "select * from t_students where stu_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,3);
        ResultSet set = statement.executeQuery();
        while (set.next()){
            String name = set.getString("stu_name");
            System.out.println(name);
        }
    }
}
