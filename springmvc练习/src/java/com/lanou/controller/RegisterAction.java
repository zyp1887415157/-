package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class RegisterAction {
    @RequestMapping("/register.action")
    public String register(){
        return "register";
    }

    @RequestMapping("/success.action")
    public String success(Person person , Map map){
        map.put("person",person);
        return "success";
    }
}
