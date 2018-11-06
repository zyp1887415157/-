package com.lanou;
import org.junit.Test;
public class TestJunit {
    public static void main(String[] args) {
        System.out.println("test main");
        TestJunit test = new TestJunit();
        test.test();
    }


    @Test
    public void test(){
        System.out.println("test junit");
    }
}
