package com.lanou3g.数据库连接池;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class noDbutils {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "select * from t_students";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        while (set.next()){
            String id = set.getString("stu_id");
            String name = set.getString("stu_name");
            System.out.println(id+" "+name);
//            System.out.println(name);
        }

    }
}
