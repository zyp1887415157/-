package com.lanou.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@Controller
public class LoginAction4 {

    @RequestMapping("/login.action")
    public ModelAndView login() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/success.action")
    /*
    public ModelAndView success(Person person) {
        System.out.println("success---" + person);
        Map map = new HashMap();
        map.put("person",person);
        ModelAndView mav = new ModelAndView("success",map);
        return mav;
    }
    */
    /*
    如果返回值是String 容器会帮助我们封装成ModelAndView,此时的viewName就是String
    如果想要传递Model,可以使用参数Model/map/ModelMap
     */
//    public String success(Person person ,Map map){
//        map.put("person",person);
//        return "success";
//    }

//    public String success(Person person , Model model){
//        model.addAttribute("person",person);
//        return "success";
//    }

//    public String success(Person person ,ModelMap map){
//        map.put("person",person);
//        return "success";
//    }

    //@ModelAttribute 这个注解表示model.addAttribute("person",person);
    public String success(@ModelAttribute("person") Person person){
        return "success";
    }
}
