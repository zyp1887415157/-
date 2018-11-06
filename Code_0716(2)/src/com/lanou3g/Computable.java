package com.lanou3g;

public interface Computable {

    //接口标识的是一种能力
    //关键字:interface
    /*
    可以把接口看作一个特殊的类
    1.接口中的方法都是public的抽象方法,所以public abstract 可以省略
    2.接口中的属性  都是全局常量 public  static  final  可以省略

    抽象类是为了被继承的,接口是为了被实现的
    继承:extends
    实现:implements

    一个类只能直接继承一个类,但是可以实现多个接口,多个接口之间使用 , 隔开
    java中类是单继承的,接口是多继承的

    之前说的多态,接口同样满足
     */

     int TYPE_0 = 0;

    int compute(int x,int y);

}
