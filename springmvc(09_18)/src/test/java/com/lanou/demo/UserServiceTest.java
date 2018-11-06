package com.lanou.demo;

import com.lanou.demo.service.UserService;
import com.lanou.demo.service.UserServiceImpl;
import com.lanou.demo.service.UserServiceLog;
import com.lanou.demo.service.UserServiceTimer;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private UserService userService;

    //java源文件编译成class文件时

    /*
    动态代理:
    1.使用的JDK反射框架下的代理类
    2.使用第三方的CGLib框架
     */
    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
        userService = new UserServiceLog(userService);
        userService = new UserServiceTimer(userService);
    }


    @Test
    public void loginTest(){
        userService.login();
    }
}