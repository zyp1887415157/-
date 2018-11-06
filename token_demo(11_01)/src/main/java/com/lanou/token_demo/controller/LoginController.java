package com.lanou.token_demo.controller;

import com.lanou.token_demo.entity.User;
import com.lanou.token_demo.shiro.SimpleUsernameToken;
import com.lanou.token_demo.utils.JwtUtils;
import com.lanou.token_demo.utils.ResultWrapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @RequestMapping("/login")
    public ResultWrapper login(User user) {
//        if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
//            return ResultWrapper.success(JwtUtils.newToken(1001L,20));
//        }

        // 调用shiro的登录，然后登录成功之后获取到token
        SimpleUsernameToken token =
                new SimpleUsernameToken(user.getUserName(), user.getPassword());
        SecurityUtils.getSubject().login(token);
        String jetToken = (String) SecurityUtils.getSubject().getPrincipal();
        return ResultWrapper.success(jetToken);
    }

    @RequestMapping("/index")
    public ResultWrapper test() {
        return ResultWrapper.success("成功");
    }

}
