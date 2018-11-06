package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
public class LoginAction {


    @RequestMapping("/login.action")
    public String login(){
        return "login";
    }

    @RequestMapping("/success.action")
    public String success(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getParameter("username")+"   "+request.getParameter("password"));
        return "success";
    }
}
