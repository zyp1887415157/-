package com.lanou.token_demo.shiro;

import com.lanou.token_demo.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.stereotype.Component;

@Component
public class JwtRealm extends SimpleRealm {

    @Override
    public String getName() {
        return "JwtRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jetToken = (String) token.getPrincipal();
        try {
            String newToken = JwtUtils.autoRequire(jetToken);
            SimpleAuthenticationInfo info =
                    new SimpleAuthenticationInfo(newToken, newToken, getName());
            return info;
        } catch (Exception e) {
            throw new AuthenticationException("请重新登录");
        }
    }
}
