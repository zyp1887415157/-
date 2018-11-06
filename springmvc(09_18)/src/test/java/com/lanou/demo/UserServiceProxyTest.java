package com.lanou.demo;

import com.lanou.demo.proxy.LogHandler;
import com.lanou.demo.service.UserService;
import com.lanou.demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class UserServiceProxyTest {

     /*
    动态代理:
    1.使用的JDK反射框架下的代理类
      只能针对有接口的类进行扩展功能
    2.使用第三方的CGLib框架
      只能针对没有借口但是可继承的类扩展功能
     */

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
        //获取类的加载器
        ClassLoader classLoader = userService.getClass().getClassLoader();
//        Class<?>[] interfaces1 = userService.getClass().getInterfaces();
        //获取需要代理的类所实现的所有接口
        Class [] interfaces = {UserService.class};
        Object o = Proxy.newProxyInstance(classLoader, interfaces, new LogHandler(userService));
        userService = (UserService) o;
    }

    @Test
    public void loginTest(){
        userService.login();
    }

}
