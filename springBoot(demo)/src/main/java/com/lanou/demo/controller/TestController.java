package com.lanou.demo.controller;

import com.lanou.demo.entity.Cost;
import com.lanou.demo.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cost")
public class TestController {

    @Autowired
    private CostService costService;


    @RequestMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("张三", 1);
        return map;

    }

    @RequestMapping("/test2")
    public List<Cost> test2() {
        return costService.findAll();
    }

    @RequestMapping("/test3")
    public Cost test3(){
        return costService.findCostByCostId(11L);
    }

    @RequestMapping("/test4")
    public Integer test4(){
        costService.insertCost("小龙人",12);
        return 1;
    }

    @RequestMapping("/test1")
    public String test11() {
        return "hello springBoot";
    }
}
