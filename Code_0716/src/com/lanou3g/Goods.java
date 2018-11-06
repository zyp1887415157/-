package com.lanou3g;

public class Goods {

    static {
        // 静态代码块
        /*
        属于类的一个成员,会随着类的加载而执行.
        只执行一次
        会做一些类的初始化工作
        多个静态代码块之间一般情况下会根据书写顺序执行
         */
        System.out.println("静态代码块执行了");
    }

    {
        //代码块
        //属于对象,会随着对象的加载而执行
        //先于构造方法执行
        //创建几次就执行几次
        System.out.println("代码块1");
    }

    private String name;
    private float price;
    private int quantity;


    public Goods(String name, float price) {
//        this.name = name;
//        this.price = price;
//        this.quantity = 1;
        //调用当前三个参数的构造方法(写参数)
        //super不能调用两次
        this(name,price,1);
    }

    public Goods(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    {
        System.out.println("代码块2");
    }

    //内部类
    /*
    在某个类的内部声明的类叫做内部类
     */


}
