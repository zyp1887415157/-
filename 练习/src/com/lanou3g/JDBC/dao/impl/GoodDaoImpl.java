package com.lanou3g.JDBC.dao.impl;

import com.lanou3g.JDBC.dao.GoodDao;
import com.lanou3g.JDBC.utils.DBUtils;
import com.lanou3g.JDBC.utils.ResultHandler;
import com.lanou3g.entity.Goods;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImpl implements GoodDao {
    @Override
    public List<Goods> findAll() {
        String sql = "select * from Good";
        return DBUtils.execute(sql,new StudentQueryRun());
    }

    @Override
    public Goods findById(int id) {
        String sql = "select * from Good where id = " +id;
        return DBUtils.execute(sql,new StudentQueryRun()).get(0);
    }

    private static class StudentQueryRun implements ResultHandler<Goods>{

        @Override
        public List<Goods> handle(Statement st, String sql) throws Exception {
            ResultSet set = st.executeQuery(sql);
            List<Goods> goodsList = new ArrayList<>();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                float price = set.getFloat("price");
                int count = set.getInt("count");
                String unit1 = set.getString("unit");
                Goods goods = new Goods(id,name,price,count,unit1);
                goodsList.add(goods);
            }
            set.close();
            return goodsList;
        }
    }
}
