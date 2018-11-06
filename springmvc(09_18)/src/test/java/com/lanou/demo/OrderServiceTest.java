package com.lanou.demo;

import com.lanou.demo.service.OrderService;
import com.lanou.demo.service.OrderServiceLog;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {

    private OrderService orderService;
    @Before
    public void setUp() throws Exception {
        orderService = new OrderServiceLog();
        //AspectJ框架也可以实现静态代理
    }

    @Test
    public void findAllTest(){
        orderService.findAll();
    }
}