package com.lanou3g.Test01.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String mysqlUrl = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(mysqlUrl, user, password);
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        PreparedStatement insS = conn.prepareStatement("insert into Goods values (?, ?, ?, ?, ?)");
        FileReader reader = new FileReader("snack-list.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while ((line = br.readLine()) != null){
            String[] arr = line.split(",");
            insS.setInt(1, Integer.parseInt(arr[0]));
            insS.setString(2, arr[1]);
            insS.setFloat(3, Float.parseFloat(arr[2]));
            insS.setInt(4, Integer.parseInt(arr[3]));
            insS.setString(5, arr[4]);
            insS.executeUpdate();
        }

        conn.commit();
        st.close();
        conn.close();
    }
}
