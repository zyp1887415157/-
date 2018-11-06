package com.lanou3g;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //异常
        /*
        算数异常
        数组越界 字符串越界  下标越界
        数字格式化异常
        空指针异常
        类型转换异常
         */
        //异常会导致程序的中断
        //异常也是类

        NullPointerException n = new NullPointerException("去你妹的空指针");

        //获得异常信息
        System.out.println(n.getMessage());
        System.out.println("-----------");


        //在控制台打印该异常的日志
        n.printStackTrace();


//        throw n;
        /*
        JAVA中的所有出错分为两类:
        Throwable
        1.Error  错误  通过一般的代码修改无法处理的,不能捕获
        2.Exception  异常   可以通过try/catch  抛出异常来处理

        Exception下面分为两类:
        1.RuntimeException  运行时异常
        2.其他异常   强制检查型异常
         */

//        Object o = new Object();
//        Main m = (Main) o;


        //异常的处理
        /*
        异常的捕获
        语法格式:
        try{
        可能会抛出异常的代码
        }catch(XXXXException e){
        解决该异常的代码
        }
         */


        Object o = null;

        /*
        try...catch..的执行过程
        如果try代码块中没有异常,所有catch都不会执行
        如果try代码块中某一行代码出现异常,try中该行以后的代码都不会执行
        检查catch有没有捕获对应的异常,如果有,则执行对应的代码块,如果没有,则程序中断
        catch捕获异常的时候,按照先后顺序依次判断,符合多态规则.
        书写catch的时候要把子类写前面
         */
        try {
            System.out.println("start");
            System.out.println(5 / 0);
            System.out.println(o.toString());
        } catch (NullPointerException e) {
            System.out.println("出现了空指针");
        } catch (ArithmeticException e) {
            System.out.println("算数异常");
        } finally {
            //不管是否捕获到异常,该代码块都会执行
            //一般会在该位置执行一些释放资源的操作
        }
        //try...catch..finally结构中(catch/finally)可以省略
        //catch/finally  至少有一个

        System.out.println("测试程序是否执行完成");

        //抛出异常  throw
        //语法 : throw  异常对象
        //常用于方法中,对调用者传递的参数进行规则性的校验
        div(-1,5);


        IOTest t = new IOTest();
        try {
            t.test(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int div(int x, int y) {
        //规定该方法只能计算两个正整数的除法
        if (x <= 0 || y <= 0) {

            throw new NumberNotBeNegativeException(x, y);
        }
        return x / y;
    }

}
