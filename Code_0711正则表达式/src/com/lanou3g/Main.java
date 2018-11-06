package com.lanou3g;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // 随机数
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10));
        }
        // nextInt(int bound) 随机获取一个[0,bound)范围的整数


        //日期类
        //单例模式 / 静态工厂    23种设计模式之一
        Calendar calendar = Calendar.getInstance();

        //获取日期相关的数据
        int i = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(i);

        //日期计算
        //给日期中的某个属性加某个值
        calendar.add(Calendar.YEAR, 5);
        calendar.set(1998, 8, 01);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayOfYear);

        // 正则表达式
        //作用:
        /*
        1.用来判断某个字符串是不是符合某个规则
        2.在某个字符串中查找某个规则的子串
        */
        String str = "ladskfo*oo ohl+daj+sfo*lsad$jfld$sjfoaaa";
        //正则表达式中的 + 号 ,表示匹配前面的字符1个或多个
        // String[] split = str.split("fo+");

        // 正则表达式中的 * 号 ,表示匹配前面的字符0个或多个
        String[] split = str.split("fo*");
        // | 代表或
        //[]  代表匹配一个字符,匹配和规则为[]里面的任意一个
        // String[] split1 = str.split("\\*| |;\\+");
        String[] split1 = str.split("[* $]+");
        System.out.println(Arrays.toString(split));


        String email = "asdf123@123.com";
        // \\w  代替英文,数字,下划线  \\d   代替数字   \\s 代替所有空白(空格\n ,换行\t,制表符\r)
        String rex = "[\\w]{6,}+@[a-zA-Z0-9]+\\.com";
        System.out.println(email.matches(rex));

        //判断是否符合正则表达式要求
        boolean matches = Pattern.matches(rex, email);
        System.out.println(matches);


        //基本数据类型的包装类
        int a = 5;
        Integer n = 5;
        int num = Integer.parseInt("678");
        Byte x = 3;
        Short s = 3;
        Long l = 3L;
        Float f = 3.5F;
        Double d = 1.1;
        Character c = 'd';
        Boolean flag = false;

        Integer a1 = 100;
        Integer a2 = 100;
        Integer b1 = 200;
        Integer b2 = Integer.valueOf(200);

        System.out.println(a1 == a2);//判断地址是否相同
        System.out.println(a1.equals(a2));//判断值是否相同
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));

        float v = Float.parseFloat("7.8");
        System.out.println(num);
        System.out.println(v);
        // String[] split1 = str.split("\\*| |;\\+");


        //person类


    }
}
