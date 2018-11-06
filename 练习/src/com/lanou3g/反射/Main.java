package com.lanou3g.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class   Main {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<? extends Person> clazz1 = p.getClass();
        Class<Person> clazz2 = Person.class;
        Class<?> clazz3 = Class.forName("com.lanou3g.反射.Person");

        //通过反射创建一个类的对象
        Person person = clazz1.newInstance();
        //获取一个类中的所有方法
        Method[] methods = clazz1.getDeclaredMethods();
        //获取一个特定的方法 (方法名  参数类型)
        Method eat = clazz1.getDeclaredMethod("eat", String.class);
        //方法  (对象   参数)
        eat.invoke(person, "吃饭");
        //将方法设置为可访问的
        eat.setAccessible(true);

        //获取某个类的所有属性
        Field[] fields = clazz1.getDeclaredFields();
        //获取指定的属性
        Field name = clazz1.getDeclaredField("name");
        //获取类的全名
        String name1 = clazz1.getName();
        System.out.println(name1);
        //获取简称
        String simpleName = clazz1.getSimpleName();
        System.out.println(simpleName);

        //获取所有的构造方法
        Constructor<?>[] constructors = clazz1.getConstructors();
        //获取无参数的构造方法
        Constructor constructor = clazz1.getConstructor();
        //获取有参数的构造方法
        Constructor constructor1 = clazz1.getConstructor(String.class);
        //利用无参数构造方法创建对象
        Object o = constructor.newInstance();
        //利用有参数的构造方法创建对象
        Object o1 = constructor1.newInstance("燕小六");



        //获取自己及父类的所有的public的属性
        Field[] fields1 = clazz1.getFields();
        //获取下标为0的那个属性
        Field field = fields1[0];
        String name3 = field.getName();
        System.out.println(name3);
        //设置为可访问的
        field.setAccessible(true);
        //通过反射修改某个对象的某个属性的值
        field.set(person, 14);
        //获取属性名字
        String name2 = field.getName();
        System.out.println(name2);
        //获取值
        Object o2 = field.get(person);
        System.out.println(o2);
        System.out.println("___________");


    }

}
