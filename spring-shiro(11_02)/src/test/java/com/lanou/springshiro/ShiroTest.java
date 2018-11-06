package com.lanou.springshiro;

import com.lanou.springshiro.shiro.SimpleToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


public class ShiroTest {

    @Test
    public void test() {
        // 1. 创建工厂，加载配置文件  配置文件主要是  给SecurityManager设置realm
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2. 使用工厂对象创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 3. 把securityManager设置给工具类
        SecurityUtils.setSecurityManager(securityManager);
        // 4. 获取当前用户
        // 如果当前没有人登陆过，那么该方法获取的是一个临时用户，如果在登陆之后调用该方法，那么获取得是当前登录的用户
        Subject currentUser = SecurityUtils.getSubject();
        // 5.判断当前用户是否已经认证了
        if (!currentUser.isAuthenticated()) {
            // 6.去登陆
//            UsernamePasswordToken token =
//                    new UsernamePasswordToken("admin", "admin");
            SimpleToken token = new SimpleToken("role", "123");
            try {
                // 如果正常执行没有抛出异常，那么就成功登陆
                currentUser.login(token);
                System.out.println("登录成功");
                // 7.判断角色和权限
                System.out.println(currentUser.hasRole("admin"));
                System.out.println(currentUser.hasRole("money"));
                System.out.println("==========================");
                // 断言  如果两个参数相等正常执行，否则报错
                Assert.assertEquals(currentUser.isPermitted("admin:query"), true);
                Assert.assertEquals(currentUser.isPermitted("admin:insert"), true);
                Assert.assertEquals(currentUser.isPermitted("money:query"), false);
                Assert.assertEquals(currentUser.isPermitted("money:insert"), false);
                Assert.assertEquals(currentUser.isPermitted("money:delete"), true);
                Assert.assertEquals(currentUser.isPermitted("money:update"), true);

            } catch (UnknownAccountException e) {
                // 用户名未找到
                System.out.println("用户名未找到");
            } catch (IncorrectCredentialsException e) {
                // 密码错误
                System.out.println("密码错误");
            }
        }
    }
}
