package com.lanou.java;

import org.junit.Test;

import java.lang.reflect.Constructor;



/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    //@Test 表示使用junit测试单元,作为测试的入口
    //@Test标注的函数,不能有参数
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        String str = "com.lanou.java.Person";
        this.test(str);
//        Person person = new Person();
//        test2(person);
    }

    public void test(String str) throws Exception {
        Class clazz = Class.forName(str);
        Constructor con = clazz.getConstructor();
        Object obj = con.newInstance();
        if (obj instanceof Person){
            ((Person) obj).eat();
        }

    }

    public void test2(Object obj){
        if (obj instanceof Person){
            ((Person) obj).eat();
        }
    }
}
