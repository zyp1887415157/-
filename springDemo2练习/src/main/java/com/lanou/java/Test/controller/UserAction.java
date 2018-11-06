package com.lanou.java.Test.controller;

import com.lanou.java.Test.mondle.service.UserService;
import com.lanou.java.Test.mondle.vo.Book;
import com.lanou.java.Test.mondle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserAction {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        List<Book> books = userAction.userService.showAll();
        System.out.println(books);
    }
}
