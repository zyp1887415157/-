package com.lanou.spring_shiro_test.shiro;

import com.lanou.spring_shiro_test.entity.SysPermission;
import com.lanou.spring_shiro_test.entity.SysRole;
import com.lanou.spring_shiro_test.entity.UserInfo;
import com.lanou.spring_shiro_test.service.UserInfoService;
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
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ShiroRealm extends AuthorizingRealm {


    @Resource
    private UserInfoService userInfoService;


    @Override
    public String getName() {
        return "ShiroRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Subject subject = SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        List<SysRole> roleList = userInfo.getRoleList();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole sysRole : roleList) {
            info.addRole(sysRole.getRole());
            for (SysPermission permission : sysRole.getPermissions()) {
                info.addStringPermission(permission.getPermission());
            }

        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        UserInfo userInfo = userInfoService.login(username, password);
        if (userInfo != null) {
            SimpleAuthenticationInfo info =
                    new SimpleAuthenticationInfo(userInfo, password, getName());
            return info;
        }
        throw new AuthenticationException("登录失败");
    }
}
