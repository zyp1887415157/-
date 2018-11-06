package com.lanou.demo.mapper;

import com.lanou.demo.entity.Goods;
import com.lanou.demo.entity.GoodsCategory;

import java.util.List;

public interface CategoryMapper {


    GoodsCategory findById(Integer id);

    List<GoodsCategory> findAllWithGoods();

}
