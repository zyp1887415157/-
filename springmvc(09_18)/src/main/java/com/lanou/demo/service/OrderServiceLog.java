package com.lanou.demo.service;

public class OrderServiceLog extends OrderService {

    @Override
    public void findAll() {
        System.out.println("OrderService.findAll 执行");
        super.findAll();
        System.out.println("OrderService.findAll 结束");
    }
}
