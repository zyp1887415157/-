package com.lanou3g.demo;

/**
 * @author liushuqing
 * Created by  18/7/9 上午11:14
 */
public class Person {
    private String name;
    private int age;
    /*
     setter&getter 方法存在的意义:
     1.把属性的修改过程移动到当前类中
     这样当前的类就保留了对该属性的修改权限,
     可以方便的对其进行控制,防止属性被非法修改
     2.可以分别对某个属性的读写权限进行控制
     */

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
        }else {
            this.age = age;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /*
    方法的重载 Overload
    在同一个类中,多个方法的方法名相同,但是参数列表不一样,
    这些方法的关系叫做重载
    参数列表不一样:类型/数量/顺序
     */
    public void eat() {
//        System.out.println("eat");
        eat("东西");
    }

    public void eat(String food) {
        System.out.println("eat" + food);
    }

    public void eat(String food, int times) {
        for (int i = 0; i < times; i++) {
            eat(food);
        }
    }

    public void eat(int times, String food) {
        System.out.println("大王叫我来巡山");
    }

}
