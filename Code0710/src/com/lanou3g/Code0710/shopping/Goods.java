package com.lanou3g.Code0710.shopping;

public class Goods {
    public static int index = 0;

    private float price;
    private String name;

    //构造方法:方法名与类名相同,没有返回值类型;
    // 如果一个类中没有构造方法,那么会有一个隐藏的默认构造方法
    //创建对象的时候会调用构造方法
    //如果类中定义了带参数的构造方法,那么默认的就会消失
    //构造方法是可以重载的

//    public Goods() {
//
//    }

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

//    public void show(String name , float price){
//        System.out.println("叫"+name+"价格"+price);
//    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }



}
