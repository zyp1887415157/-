package com.lanou.token_demo.shiro;

import org.apache.shiro.authc.AuthenticationToken;
// 两套验证信息  一个是验证用户名密码   一个是验证token是否正确
public class JwtToken  implements AuthenticationToken {


    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
