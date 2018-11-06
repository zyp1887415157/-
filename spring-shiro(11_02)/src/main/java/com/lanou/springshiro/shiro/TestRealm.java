package com.lanou.springshiro.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class TestRealm implements Realm {

    @Override
    public String getName() {
        return "TestRealm";
    }

    /**
     * 用来判断自定义的realm是否支持某个token
     * 前提：在登录的时候需要调用login方法，并传递一个token对象
     * 如果把该realm设置给SecurityManager，那么在使用Shiro登录
     * 的时候，登陆的逻辑就在该realm里，
     * 所以就得判断一下，该realm是否可以处理login的传递进来的token
     *
     * @param token
     * @return
     */
    // 传来一个token 判断 若果返回true则继续往下走，如果返回false则使用别的realm
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 拿到用户名
        String username = (String) token.getPrincipal();
        // 拿到密码
        char[] tempPassword = (char[]) token.getCredentials();
        String password = new String(tempPassword);
        // 查数据库
        if ("admin".equals(username) && "admin".equals(password)) {
            // 登录成功
            AuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(username, password, getName());
            return authenticationInfo;
        } else {
            // 登录失败
            throw new AuthenticationException("用户名/密码错误");
        }
    }
}
