package com.lanou3g;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        //有键盘输入10个整数,求和

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "整数:");
            try {
                int a = scanner.nextInt();
                sum += a;
            } catch (Exception e) {
                System.out.println("请输入数字");
                i --;
                scanner = new Scanner(System.in);
            }

        }
        System.out.println("和为:" + sum);


    }
}
