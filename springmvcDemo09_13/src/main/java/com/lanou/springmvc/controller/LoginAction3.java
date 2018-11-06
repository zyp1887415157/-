package com.lanou.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class LoginAction3 {
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

//    @RequestMapping("/success.action")
//    public String success(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("success---"+request.getParameter("username"));
//        return "success";
//    }
        //  变量的名字
//    @RequestMapping("/success.action")
//    public String success(String username,String password){
//        System.out.println("success---"+username);
//        return "success";
//    }

    //  参数是  模型类
//    @RequestMapping("/success.action")
//    public String success(Person person){
//        System.out.println("success---"+person.getUsername());
//        return "success";
//    }

    @RequestMapping(value = "/success.action",method = RequestMethod.GET)
    public String success(Person person, String username) {
        System.out.println("success---" + person.getUsername() + " " + username);
        return "success";
    }

    //  参数添加注解
    @RequestMapping("/success.action")
    public String success(@RequestParam("username") String userna, String password) {
        System.out.println("success---" + userna + "  " + password);
        return "success";
    }
}
