package com.lanou.demo.mapper;

import com.lanou.demo.entity.Order;
import com.lanou.demo.entity.OrderMoney;

import java.util.List;

public interface OrderMapper {

    // 查询所有订单
    List<Order> findAll();

    //查询某个订单
    Order findByid(int id);


    //查询所有订单和总价
    List<OrderMoney> findAllWithMoney();
}
