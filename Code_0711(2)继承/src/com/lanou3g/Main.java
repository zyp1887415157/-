package com.lanou3g;

import com.lanou3g.zoo.*;

public class Main {
    public static void main(String[] args) {



        Penguin p = new Penguin("QQ",100);
        p.eat();
        p.sleep();
        p.introduction();
        p.catchFish();

        Mouse mouse = new Mouse("米老鼠",7);
        mouse.eat();
        mouse.sleep();
        mouse.introduction();
        mouse.stealOil();

        Cat cat = new Cat("汤姆",8);
        cat.eat();
        cat.play();

        /*
        final  关键字
        他可以修饰类/方法/属性,
        修饰类,那么该类不能被继承;
        修饰方法,那么该方法不能被重写;
        修饰属性,那么该属性的值不能被改变
         */

        Animal a1 = new Animal("蛤蟆",1);
        Animal a2 = new Animal("蛤蟆",1);
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
        /*
        直接打印一个对象的时候,实际上在打印该对象的toString()方法的返回值,
        那么我们可以重写该方法,自定义打印内容
         */
        System.out.println(a1);


        p.eat();
        mouse.eat();
        System.out.println("--------多态--------");

        /*
            多态的原则:
                当调用某个对象的某个方法时,
                系统会看这个对象的真实类型是什么,
                调用的永远都是这个真实对象的方法.


                多态的表现形式:
                    1. 父类声明对象 由子类初始化(创建对象).
                    2. 如果一个方法的参数中,需要传递某个类型的参数,
                       那么该类型的子类对象都可以进行传递.
                    3. 如果一个方法的返回值是某个类型,
                       那么该类型的所有子类对象都可以作为返回值.
         */
        /*
           多态存在的三个必要条件
           继承
           重写(构造方法不能被重写)
           父类引用指向子类对象
           好处:  可替换性,可扩充性,简化性,灵活性,接口性
         */
        //多态的表现形式
        //1.父类声明对象,由子类创建对象(初始化)
        Animal animal1 = new Penguin("企鹅",250);
        Animal animal2 = new Mouse("老鼠",260);
        animal1.eat();
        animal2.eat();
        Object obj = animal1;
        System.out.println(obj);
        System.out.println("============");


        //2.如果一个方法的参数中,需要传递某一个类型的参数,
        //那么该类型的子类对象都可以进行传递
        Feeder feeder = new Feeder();
        feeder.feed(p);
        feeder.feed(mouse);
        feeder.feed(animal1);
        feeder.feed(animal2);
        System.out.println(mouse instanceof Animal);
        System.out.println(mouse instanceof Mouse);

        //3.如果一个方法的返回值是某个类型
        //那么该类型的所有子类对象都可以作为返回值

        Animal a = feeder.catchOne(Feeder.TYPE_P);
        Animal b = feeder.catchOne(2);

        if (a instanceof Penguin){
            Penguin p1 = (Penguin) a;//向下转型
            p1.catchFish();
            feeder.feed(a);
        }else if (a instanceof Mouse){
            Mouse m = (Mouse) a;
            m.stealOil();
        }

    }
}
