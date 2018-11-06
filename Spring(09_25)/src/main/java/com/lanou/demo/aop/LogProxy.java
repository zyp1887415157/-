package com.lanou.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogProxy {

    @Pointcut("execution(* com.lanou.demo.service.*.*(..))")
    public void allServiceMethod() {

    }

    @Before("allServiceMethod()")
    public void before(JoinPoint jp){
        Object target = jp.getTarget();
        String name = jp.getSignature().getName();
        System.out.println(target.getClass().getName()+"."+name+"方法执行之前");
    }

    @After("allServiceMethod()")
    public void After(JoinPoint jp){
        Object target = jp.getTarget();
        String name = jp.getSignature().getName();
        System.out.println(target.getClass().getName()+"."+name+"方法执行之后");
    }
}
