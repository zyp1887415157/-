package com.lanou3g;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        //反射

        /*
        由什么组成一个类
        修饰符
        类名
        属性
        构造方法
        普通方法

        由什么组成一个属性
        修饰符
        数据类型
        变量名
        初始值

        由什么组成构造方法
        修饰符
        方法名
        参数

        什么组成方法
        修饰符
        返回值
        方法名
        参数
         */

        Person p = new Person();
        //第一种获取Person类的类型
        /*
        存在任意一个类 P,
        P.class 代表获取的一个Class类的对象
        该对象保存了P类的所有信息
         */
        Class<Person> clazz1 = Person.class;
        //有的时候,有的是某个类的对象
        Class clazz2 = p.getClass();
        //有的时候,既没有类,也没有对象,但是知道类名
        try {
            Class clazz3 = Class.forName("com.lanou3g.Person");
            //通过反射创建一个类的对象
            //前提是存在默认的构造方法
            Object o = clazz3.newInstance();

            //获取一个类中的所有方法
            Method[] methods = clazz3.getMethods();
            //获取的是一个参数的eat方法(方法名,参数类型)
            Method eat = clazz3.getDeclaredMethod("eat", String.class);
            eat.setAccessible(true);//设置为可访问的  对象.setAccessible(true)
            //(对象,参数值)
            Object result = eat.invoke(o, "吃饭");
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取某个类的所有属性
        Field[] fields = clazz1.getDeclaredFields();
        Field name = clazz1.getDeclaredField("name");

        //类的全名
        String name1 = clazz1.getName();
        //简称
        String simpleName = clazz1.getSimpleName();
        //获取类加载器
        ClassLoader classLoader = clazz1.getClassLoader();

        //获取所有构造方法
        Constructor<?>[] constructors = clazz1.getConstructors();
        //获取无参构造方法
        Constructor<Person> constructor = clazz1.getConstructor();
        //利用无参构造方法创建对象
        Person person = constructor.newInstance();
        //获取带参数的构造方法(参数类型.class)
        Constructor<Person> constructor1 = clazz1.getConstructor(String.class);
        //利用有参构造方法创建对象
        Person p2 = constructor1.newInstance("燕小六");




        //获取自己即父类的所有public的属性
//        Field[] fields1 = clazz1.getFields();
        Field f = fields[0];
        int modifiers = f.getModifiers();
        System.out.println("============");
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers));
        System.out.println("============");
        System.out.println(f.getName());
        System.out.println(f.getType().getName());

        //获取某个属性的值,前提是对象要存在

        f.setAccessible(true);//设置该属性为可访问的
//        p.name = "张三";
        //通过反射 读取属性的值
        try {

            //通过反射修改某个对象的某个属性的值
            f.set(p,"李四");
//            System.out.println(p.name);

            Object o = f.get(p);//相当于p.name
            System.out.println(o);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
