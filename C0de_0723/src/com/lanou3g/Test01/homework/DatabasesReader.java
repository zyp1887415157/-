package com.lanou3g.Test01.homework;

import com.lanou3g.Test01.entity.Goods;
import com.lanou3g.Test01.entity.GoodsList;
import com.lanou3g.Test01.equipment.GoodsShelf;
import com.lanou3g.Test01.staff.ListFileReader;

import java.sql.*;

public class DatabasesReader implements ListFileReader {

    @Override
    public boolean loadListToShelf(GoodsList list, GoodsShelf shelf) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String mysqlUrl = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        try {
            Connection conn = DriverManager.getConnection(mysqlUrl, user, password);
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select * from Goods");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String unit = resultSet.getString(5);
                Goods g = new Goods();
                g.setId(id);
                g.setName(name);
                g.setPrice(price);
                g.setUnit(unit);
                shelf.addGoods(g, quantity);
            }

            resultSet.close();
            st.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean store(GoodsList list2, GoodsShelf shelf2) {
        return false;
    }
}
