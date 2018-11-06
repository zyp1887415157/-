package com.lanou3g.JDBC.homework;

import com.lanou3g.JDBC.utils.DBUtils;
import com.lanou3g.entity.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        //1.获取连接
        Connection conn = DBUtils.getConnection();
        String sql = "select * from Goods";
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(sql);
        List<Goods> goodsList = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt("id");
            String name = set.getString("name");
            float price = set.getFloat("price");
            int count = set.getInt("count");
            String unit1 = set.getString("unit");
            Goods goods = new Goods(id, name, price, count, unit1);
            goodsList.add(goods);
        }
        for (Goods goods : goodsList) {
            int id = goods.getId();
            String name = goods.getName();
            float price = goods.getPrice();
            int count = goods.getCount();
            String unit = goods.getUnit();
            System.out.println(id + " " + name + " " + price + " " + count + " " + unit + "\t");


        }
    }
}
