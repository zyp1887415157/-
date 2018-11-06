package com.lanou.demo.mapper;

import com.lanou.demo.entity.GoodsCategory;

import java.util.List;

public interface CategoryMapper {

    /**
     * 第一个方法只查询类别单表
     * 第二个方法会把某个类别所对应的商品也会查出来
     * @return
     */
    List<GoodsCategory> findAllSimple();

    List<GoodsCategory> findAll();
}
