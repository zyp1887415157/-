package com.lanou.token_demo.shiro;

import com.lanou.token_demo.entity.SysPermission;
import com.lanou.token_demo.entity.SysRole;
import com.lanou.token_demo.entity.UserInfo;
import com.lanou.token_demo.service.UserInfoService;
import com.lanou.token_demo.utils.JwtUtils;
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

@Component
public class SimpleRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    public String getName() {
        return "SimpleRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof SimpleUsernameToken;
    }

    // 授权（设置角色权限）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 授权

        // 获取用户对象
//        Subject subject = SecurityUtils.getSubject();
        // 因为认证的时候存储的是UserInfo的对象，所以取出来的也是UserInfo对象
//        UserInfo user = (UserInfo) subject.getPrincipal();
        // 创建授权信息对象  因为方法返回值是 AuthorizationInfo 所以可以创建他的实现类

        // 获取登陆成功时存储的主要信息
        // 实际上是token
        Object principal = principals.getPrimaryPrincipal();
        String jwtToken = (String) principal;
        // 从token信息中获取到用户id
        Integer userId = JwtUtils.getUserId(jwtToken);
        UserInfo user = userInfoService.findBy(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 遍历用户的所有角色
        for (SysRole sysRole : user.getRoleList()) {
            // 将遍历出来的的角色信息放入到授权信息对象中
            info.addRole(sysRole.getRole());
            // 根据角色信息获取所对应的权限信息
            for (SysPermission permission : sysRole.getPermissions()) {
                // 将权限信息也放入到授权信息对象中
                info.addStringPermission(permission.getPermission());
            }
        }
        // 返回  授权对象
        return info;
    }

    // 认证是否登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 根据传来的token 获取用户名和密码
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();


        // 调用service层的方法，获取用户对象
        UserInfo userInfo = userInfoService.login(username, password);
        // 判断这个对象是否为空
        // 如果不为空
        if (userInfo != null) {
            String jwtToken = JwtUtils.newToken(userInfo.getUserId());
            // 说明从数据库中能查到用户
            // 因为方法的返回值是  AuthenticationInfo 我们可以创建他的实现类
            SimpleAuthenticationInfo info =
                    // 为了方便之后的调用  主要信息存的是该用户的详情
                    new SimpleAuthenticationInfo(jwtToken, password, getName());
            return info;
        }
        throw new AuthenticationException("登录失败");
    }
}
