package com.lanou3g.homework;

import com.lanou3g.entity.Goods;
import com.lanou3g.utils.DBUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("snack-list.txt");
        BufferedReader reader1 = new BufferedReader(reader);
        String line = "";
        List<Goods> goodsList = new ArrayList<>();
        Connection conn = DBUtils.getConnection();


        String sql = "insert into Goods(id,name,price,count,unit) values (?,?,?,?,?) ";
        PreparedStatement statement = conn.prepareStatement(sql);
        while ((line = reader1.readLine()) != null) {
            String[] split = line.split(",");
            Goods goods = new Goods();
            goods.setId(Integer.parseInt(split[0]));
            goods.setName(split[1]);
            goods.setPrice(Float.parseFloat(split[2]));
            goods.setCount(Integer.parseInt(split[3]));
            goods.setUnit(split[4]);
            goodsList.add(goods);
        }
        for (Goods goods : goodsList) {
            statement.setInt(1, goods.getId());
            statement.setString(2, goods.getName());
            statement.setFloat(3, goods.getPrice());
            statement.setInt(4, goods.getCount());
            statement.setString(5, goods.getUnit());
            statement.executeUpdate();
        }
        statement.close();
        conn.close();
        reader1.close();
        reader.close();
    }
}
