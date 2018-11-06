package com.lanou3g.zoo;

import java.util.Objects;

public class Animal extends Object {
    public static final int AAA = 5;


    //在java中 如果父类没有明确指定父类类型,那么他就继承Object这个类
    //java中类是单继承的,就是说 一个类同时只能继承一个类



    /*
    如果父类的属性是private,那么子类不能直接调用该属性,
    但是可以通过父类的getter&setter方法 间接的使用该属性
     */
    private String name;
    private int id;


    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /*
    重写父类Object类的equals方法
    重新定义两个对象是否相等的规则
     */
//    public boolean equals(Object obj){
//        if (this==obj){
//            return true;
//        }
//        //判断obj对象是不是animal类型
//        if (obj instanceof Animal){
//            Animal other = (Animal) obj;
//            return this.name.equals(other.name) & this.id == other.id;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(name, animal.name);
    }



    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }


    /*
    重写Object类的toString()方法
   返回该对象的所有属性
     */
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("Animal {");
//        sb.append("name = ").append(name).append("id =").append(id).append("}");
//        return  sb.toString();
//    }


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Animal setId(int id) {
        this.id = id;
        return this;
    }

    public void eat() {
        System.out.println(name + "正在吃鱼");
    }

    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    public void introduction() {
        System.out.println("大家好,我是" + id + "号,我叫" + name);

    }
}
