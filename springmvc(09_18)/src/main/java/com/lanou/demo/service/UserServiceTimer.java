package com.lanou.demo.service;

public class UserServiceTimer implements UserService {

    private UserService userService;

    public UserServiceTimer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login() {
        long last = System.currentTimeMillis();
        userService.login();
        long time = System.currentTimeMillis() - last;
        System.out.println("UserService.login 耗时:" + time + "毫秒");
    }
}
