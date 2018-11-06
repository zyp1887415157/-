package com.lanou.demo.mapper;

import com.lanou.demo.entity.User;

import java.util.List;

public interface UserMapper {

    //查询所有人携带出所有信息  人->订单->商品->类别
    List<User> findAllStrong();
}
