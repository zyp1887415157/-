package com.lanou.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//@Controller
public class LoginAction2  {
    //通常函数的返回值是ModelAndView
    //如果不需要传递参数,返回String类型
    //容器会帮助我们进行封装,把String变成viewName,生成一个ModelAndView
    @RequestMapping("/login.action")
    public String login(){
        return "login";
    }


    @RequestMapping("/success.action")
    public String success(HttpServletRequest request, HttpServletResponse response){
        System.out.println("************"+request.getParameter("username"));
       return "forward:suc.action";        // 转发携带值
//        return "redirect:suc.action";   //重定向 不携带值
    }

    @RequestMapping("/suc.action")
    public String suc(HttpServletRequest request, HttpServletResponse response){
        System.out.println("************"+request.getParameter("username")+"suc");
        return "success";
    }
}
