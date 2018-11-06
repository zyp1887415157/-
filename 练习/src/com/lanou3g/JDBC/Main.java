package com.lanou3g.JDBC;

import com.lanou3g.JDBC.dao.GoodDao;
import com.lanou3g.JDBC.dao.impl.GoodDaoImpl;
import com.lanou3g.entity.Goods;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GoodDao goodDao = new GoodDaoImpl();
        List<Goods> all = goodDao.findAll();
        System.out.println(all);
    }
}
