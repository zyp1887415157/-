package com.lanou.spring_shiro_test.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class ShiroToken implements AuthenticationToken {


    private String username;
    private String password;

    public ShiroToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
