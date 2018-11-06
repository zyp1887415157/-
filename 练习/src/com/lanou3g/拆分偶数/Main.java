package com.lanou3g.拆分偶数;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i += 2) {
            split(i);
        }
    }

   static boolean zhishu(int num) {
        for (int i = 2; i < 100; i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    private static void split(int num){
        for (int a = 2; a < num/2; a++) {
            int b = num - a;
            if (zhishu(a)&&zhishu(b)){
                System.out.println(num+"="+a+"+"+b);
            }
        }
    }
}
