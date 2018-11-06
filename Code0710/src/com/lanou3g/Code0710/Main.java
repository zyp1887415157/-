package com.lanou3g.Code0710;

import com.lanou3g.Code0710.shopping.Goods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //创建对象的公式
        // 类名 对象名 = new 类名();
        // 实际上是 类名 对象名 = new 构造方法;
        Goods phone = new Goods("张三", 199F);
        Goods cloths = new Goods("衣服", 199F);
//        phone.index = 10;
//        cloths.index = 30;
        Goods.index = 10;
        Goods.index = 30;

        System.out.println(Goods.index);//输出30 index被改变了两次 最后变成30 所以会输出30


//        phone.name = "手机";
//        phone.price = 1999F;

//        phone.show("akds",199F);

        System.out.println(phone.getName() + phone.getPrice());


        /*
        方法的构成:
        0个或多个修饰符 返回值类型 方法名(参数列表){
             方法体:
        }
         */
        //static 修饰的方法可以直接用 类名.方法 调用
        //普通方法可以调用静态方法,静态方法不能调用普通方法只能调用静态方法
//        在创建对象的时候,会先加载类,然后在创建对象,静态方法优先于对象被创建出来,所以普通方法可以调用静态方法
//        静态方法调用普通方法的时候还没有对象,调用不到普通方法
        //   static  修饰的变量,被所有对象共享
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));

        // static  静态的
        /*
        当创建一个对象的时候,实际上系统会先加载类,然后在创建对像  类只会加载一次
        被static修饰的属性/方法  属于类不属于对象
        所以static 修饰的属性/方法 可以直接通过类名调用
         */
        // 什么时候使用静态方法?
        /*
        1.当方法中不需要引用成员变量的时候,这个方法可以声明为静态方法
        2.工具方法一般都会声明为静态的
         */

        int num = -100;
        int abs = Math.abs(num);
        System.out.println(abs);

        int result = Math.diss(3);
        System.out.println(result);

        int result1 = Math.fi(5);
        System.out.println(result1);



    }

}
