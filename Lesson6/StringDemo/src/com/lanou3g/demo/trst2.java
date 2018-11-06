package com.lanou3g.demo;

public class trst2 {
    public static void main(String[] args) {
//        String a = "12345";
//        int b = Integer.valueOf(a);
//        System.out.println(b);


        String a1 = "12345";
        int result = 0;
        int r = 1;
        for (int i = a1.length() - 1; i >= 0; i--) {
            char ch = a1.charAt(i);
            int n = ch - 48;
            System.out.println(n+"=====");
            result += n * r;
            r *= 10;
        }
        System.out.println(result);
    }


}
