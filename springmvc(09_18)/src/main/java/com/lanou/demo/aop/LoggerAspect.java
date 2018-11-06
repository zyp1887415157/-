package com.lanou.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //标记这个类是切面
//用来控制多个切面类的织入顺序,数值越小优先级越高.
@Order(0)
public class LoggerAspect {

    /**
     * 面向切面编程(AOP)实际上在做什么?
     * 实际上就在规定代码的某个位置(何处)的什么时候(何时)做什么事(什么)
     * 比如说:在登陆的方法执行之前,打印日志
     * 何处:登陆的方法
     * 何时:执行之前
     * 什么:打印日志
     * <p>
     * 1.接入点  JoinPoint  (可以插入增强代码的地方  一般指的是方法)
     * 在spring中JoinPoint是一个类,代表被增强的了方法
     * 2.切点    Pointcut
     * 实际上是一个表达式,表示哪些方法需要增强
     * 3.通知    advice
     * 通知的作用:对切点所描述的方法进行增强,在何时怎么增强
     * 一共5种通知:
     * 前置通知  后置通知  返回通知  异常通知  环绕通知
     * 4.切面    aspect
     * 切点和通知组成切面
     * 5.织入    weave
     * 表示的是把切面与目标整合起来的过程
     */
    @Pointcut("execution(* com.lanou.demo.service.*.*(..))")
    public void allServiceMethod() {

    }

    @Before("allServiceMethod()")
    public void logBefore(JoinPoint jp) {
        //接入点对象JoinPoint中报存了被增强的方法和类的信息
        //获取到被增强的原始对象
        Object target = jp.getTarget();
        //获取被增强的方法的名字
        String name = jp.getSignature().getName();
        System.out.println(target.getClass().getName() + "." + name + "方法执行之前");

//        jp.toLongString()  返回的是该次方法调用的切点表达式
    }

    @After("allServiceMethod()")
    public void logAfter() {
        System.out.println("方法执行之后");
    }

    @AfterThrowing("allServiceMethod()")
    public void logAfterThrow() {
        System.out.println("方法抛异常了");
    }

   @AfterReturning("allServiceMethod()")
    public void logAfterReturn() {
        System.out.println("方法正常执行");
    }

    @Around("allServiceMethod()")
    //环绕通知,功能最强
    public Object around(ProceedingJoinPoint jp) {
        try {
            //前置通知
            //就是在进行方法的实际调用
            Object result = jp.proceed();
            //返回通知
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
        }
        //后置通知
        return null;
    }

}
