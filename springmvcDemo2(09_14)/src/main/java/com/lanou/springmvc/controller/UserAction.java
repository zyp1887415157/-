package com.lanou.springmvc.controller;

import com.lanou.springmvc.model.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/")
//如果该模块整体放置到虚拟路径/user/下面,可以整体配置
public class UserAction {
    //如果没有在类上面配置@RequestMapping,整个项目的根目录就是/
    //在类前面配置了@RequestMapping("/user/")之后,这个类的根目录就是/user/
    //login函数的虚拟路径是:/user/+/login.action = /user/login.action
    @RequestMapping("login.action")
    public String login() {
        return "login";
    }

    // @ModelAttibute如果不写key,默认是数据类型名(首字母小写)
    @RequestMapping(value = "success.action", method = RequestMethod.GET)
    public String success(@ModelAttribute User user) {
        //具体的登录判断
        System.out.println("----------------------get");
        return "success";
    }

    @RequestMapping(value = "/success.action", method = RequestMethod.POST)
    public String successs(@ModelAttribute User user) {
        //具体的登录判断
        System.out.println("======================post");
        return "success";
    }

    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }

    @RequestMapping("/success2.action")
    public String success2() {
        //具体的登录判断
        return "login";
    }

    @RequestMapping(value = "page.action", params = "pagenum=1")
    public String page() {

        return "first";
    }

    @RequestMapping(value = "page.action", params = "pagenum=2")
    public String page2() {

        return "second";
    }

//    @RequestMapping("/page.action")
//    public String page3(String pagenum){
//        String str = null;
//        if ("1".equals(pagenum)){
//            str = "first";
//        }else if ("2".equals(pagenum)){
//            str = "second";
//        }
//        return str;
//    }
}
