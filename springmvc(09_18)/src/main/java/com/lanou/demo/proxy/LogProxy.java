package com.lanou.demo.proxy;

import com.lanou.demo.aop.LoggerAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// jdk  动态代理  利用反射机制
public class LogProxy implements InvocationHandler {


    public static <T> T newProxyInstance(T target) {
        Class<?> clazz = target.getClass();
        //获取类加载器
        ClassLoader classLoader = clazz.getClassLoader();
        // 获取类所实现的所有接口
        Class<?>[] interfaces = clazz.getInterfaces();
        // 调用Proxy.newProxyInstance方法，创建代理对象
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new LogProxy(target));
        return (T) proxy;
    }

    private Object target;

    private LoggerAspect loggerAspect = new LoggerAspect();

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置通知
//        loggerAspect.logBefore();
        Object result = null;
        try {
            result = method.invoke(target, args);
            //返回通知  放在方法执行完之后
            loggerAspect.logAfterReturn();
        } catch (Exception e) {
            e.printStackTrace();
            //异常通知
            loggerAspect.logAfterThrow();
        }
        //后置通知
        loggerAspect.logAfter();
        return result;
    }
}
