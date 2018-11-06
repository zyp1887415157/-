package com.lanou.bookstore.controller;


import com.lanou.bookstore.model.service.UserService;
import com.lanou.bookstore.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("login.action")
    public String login() {
        return "login";
    }

    @RequestMapping("success.action")
    public String success(User user) {
        boolean login = userService.login(user);
        if (login){
            return "success";
        }
        return "login";
    }

    @RequestMapping("register.action")
    public String register() {
        return "register";
    }

    @RequestMapping("success2.action")
    public String success2(User user) {
        if (userService.register(user)){
            return "login";
        }
        return "register";
    }



    @RequestMapping("result.action")
    public String findAll(Map map) {
        List<User> all = userService.findAll();
        map.put("all", all);
        return "result";
    }

    @RequestMapping("/home.action")
    public String home(){
        return "success";
    }

}
