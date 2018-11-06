package com.lanou.token_demo.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class SimpleUsernameToken implements AuthenticationToken {


    private String username;
    private String password;

    public SimpleUsernameToken(String username, String password) {
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
