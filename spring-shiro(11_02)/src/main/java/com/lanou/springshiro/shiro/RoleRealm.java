package com.lanou.springshiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class RoleRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "RoleRealm";
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        // 如果使用SimpToken来登录
        // 那么就由该Realm处理登录逻辑
        return token instanceof SimpleToken;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 拿到用户名
        String username = (String) token.getPrincipal();
        // 拿到密码
        String password = (String) token.getCredentials();
        // 查数据库
        if ("role".equals(username) && "123".equals(password)) {
            // 登录成功
            AuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(username, password, getName());
            return authenticationInfo;
        } else {
            // 登录失败
            throw new AuthenticationException("用户名/密码错误");
        }
    }


    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 应该做的事儿：
        // 去数据库查询当前登陆的用户所有的角色和权限
        Subject subject = SecurityUtils.getSubject();
        // 获取用户名  根据用户名在数据库里查询所对应的角色和权限
        String username = (String) subject.getPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 为当前用户添加角色和权限
        info.addRole("admin");
        info.addRole("money");
        info.addStringPermission("admin:insert");
        info.addStringPermission("admin:query");
        info.addStringPermission("money:delete");
        info.addStringPermission("money:update");

        return info;
    }

}
