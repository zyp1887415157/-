package com.lanou.demo.service;

public class UserServiceLog implements UserService {

    private UserService userService;

    public UserServiceLog(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login() {
        System.out.println("UserService.login 开始执行");

        userService.login();

        System.out.println("UserService.login 执行结束");
    }
}
