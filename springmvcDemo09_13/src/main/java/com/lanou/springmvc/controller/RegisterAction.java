package com.lanou.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller
public class RegisterAction {

    @RequestMapping("/register.action")
    public String register(){
        return "register";
    }

    @RequestMapping("/success.action")
    public String success(Person person,Map map){
      map.put("person",person);
      return "success";
    }

//    @RequestMapping("/success.action")
//    public String success(String username,Map map){
//        map.put("username",username);
//        return "success";
//    }

//    @RequestMapping("/success.action")
//    public String success(Person person,Map map){
//        map.put("person",person);
//        return "success";
//    }

//    @RequestMapping("/success.action")
//    public String success(Person person, Model model){
//        model.addAttribute("person",person);
//        return "success";
//    }
}
