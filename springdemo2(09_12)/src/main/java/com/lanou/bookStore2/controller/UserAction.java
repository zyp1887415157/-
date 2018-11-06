package com.lanou.bookStore2.controller;

import com.lanou.bookStore2.model.service.UserService;
import com.lanou.bookStore2.model.vo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserAction {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        List<User> users = userAction.userService.showAll();
        System.out.println(users);
    }
}
