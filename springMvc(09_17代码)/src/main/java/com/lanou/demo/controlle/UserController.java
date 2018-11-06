package com.lanou.demo.controlle;


import com.lanou.demo.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        //只有配置了listener这个才能用
        //从ServletContext中取出容器对象
        WebApplicationContext context1 = WebApplicationContextUtils.findWebApplicationContext(context);
//        Person person = (Person) context1.getBean("userService");
        Object person =  context1.getBean("userService");
        System.out.println(person);
        return "login";
    }

    @RequestMapping("/person")
    @ResponseBody
    public Person getOne(){
        Person person = new Person();
        person.setAge(18);
        person.setName("张三");
        return person;
    }
}
