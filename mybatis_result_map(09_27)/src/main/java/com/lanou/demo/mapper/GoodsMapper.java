package com.lanou.demo.mapper;

import com.lanou.demo.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    //查询所有商品，并且把每个商品的类别信息携带出来
    List<Goods> findALlwithCategory();
}
