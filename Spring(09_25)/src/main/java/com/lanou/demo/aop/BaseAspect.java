package com.lanou.demo.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
public class BaseAspect {

    @Pointcut("execution(* com.lanou.demo.service.*.*(..))")
    public void allService(){}

}
