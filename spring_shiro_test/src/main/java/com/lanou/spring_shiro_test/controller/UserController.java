package com.lanou.spring_shiro_test.controller;

import com.lanou.spring_shiro_test.Utils.JwtUtil;
import com.lanou.spring_shiro_test.Utils.ResultWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/login")
    public ResultWrapper login(String username, String passeord) {
        if ("admin".equals(username) && "admin".equals(passeord)) {
             return ResultWrapper.success(JwtUtil.newToken(1001L,200000));
        }
        return ResultWrapper.error("登录失败");
    }

    @RequestMapping("/index")
    public String test(){
        return "success";
    }
}
