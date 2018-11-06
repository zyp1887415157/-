package com.lanou.demo.proxy;

import com.lanou.demo.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       StringBuilder builder = new StringBuilder();
       builder.append(target.getClass().getName())
               .append(".")
               .append(method.getName());
        System.out.println(builder+"开始调用");
        Object result = method.invoke(target,args);
        System.out.println("调用" +
                "结束");
        return result;
    }
}
