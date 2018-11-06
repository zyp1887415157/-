package com.lanou3g;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class IOTest {

    /*
    1.强制检查型异常,在编译期必须进行异常捕获
    2.throws
      如果在一个方法中不需要处理该异常的话,可以在方法声明时使用该关键字
      将异常向上抛出,在哪里调用该方法,就在那里在进行异常捕获
    3.throws 也遵循多态原则
     */

    public void test(int age) throws Exception {

        if (age < 0) {
            throw new IOException();
        }
        if (age < 10) {
            throw new NoSuchFileException("");
        }
    }
}
