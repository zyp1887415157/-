package com.lanou3g.JDBC.dao;

import com.lanou3g.entity.Goods;

import java.util.List;

public interface GoodDao {

    List<Goods> findAll();

    Goods findById(int id);
}
