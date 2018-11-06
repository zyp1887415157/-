package com.lanou.demo.mapper;


import com.lanou.demo.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    // 查询所有商品，并携带商品的种类
    List<Goods> findAll();
}
