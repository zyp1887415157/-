package com.lanou.springshiro.shiro;

import org.apache.shiro.authc.AuthenticationToken;

// authenticationToken  是。。。token的总接口，所以创建了他的实现类
public class SimpleToken implements AuthenticationToken {

    private String username;
    private String password;

    public SimpleToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 获取用户名
    @Override
    public Object getPrincipal() {
        return username;
    }

    // 获取密码
    @Override
    public Object getCredentials() {
        return password;
    }
}
