package com.lanou.activemq.controller;

import com.lanou.activemq.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderListController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/dispose")
    public String dispose() {
        return orderService.disposeOrder();
    }
}
