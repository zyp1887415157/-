package com.lanou3g;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }

//        日期
        Calendar calendar = Calendar.getInstance();

        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        calendar.add(Calendar.YEAR, 5);
        int i1 = calendar.get(Calendar.YEAR);
        System.out.println(i1);
//      时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);


        int count = 0;
        int end = 88480000;
        int start = 3;
        while (start < end) {
            count++;
            start *= 2;
            System.out.println("第" + count + "次厚度是" + start);
        }
        System.out.println("要叠" + count + "次");

        System.out.println("100-1000中的水仙花数");

        int a = 0;
        for (int i2 = 100; i2 < 1000; i2++) {
            int num = i2;
            int h = num / 100;
            num = num % 100;
            int t = num / 10;
            num = num % 10;


            if (i2 == h * h * h + t * t * t + num * num * num) {
                System.out.println("水仙花数是" + i2);
                a++;
            }
        }
        System.out.println(a);

        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(67);
        list.add(278);
        list.add(3);
        list.add(99);
        Collections.sort(list);
        System.out.println(list.toString());

        for (int i2 = 0; i2 < 5; i2++) {
            for (int j = 0; j <= i2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int c = 1; c <= 5; c++) {
            //将空格和*分开看，看" "的变化i=1时，它是4，2的时候是3，找规律
            for (int j = 1; j <= 5 - c; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * c - 1; k++) {//找规律，i是 1 3 5 7 9基数
                System.out.print('*');
            }
            //换一行
            System.out.println();
        }
        for (int d = 1; d <= 4; d++) {
            for (int j = 1; j <= d; j++) {//空格 1 2 3 4 so
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (4 - d + 1) - 1; k++) {//* 7 5 3 1 倒着来的基数
                System.out.print('*');
            }
            System.out.println();
        }
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.DATE));



    }
}
