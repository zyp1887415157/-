package com.lanou3g;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // 常用类
        //1.可变字符串
        // 在多线程情况下 优先使用StringBuffer ,因为他是线程安全的
        //单线程情况下优先使用StringBuilder,应为效率高
        //用法一样
        StringBuffer stringBuffer = new StringBuffer();

        StringBuilder sb = new StringBuilder();
        String[] strings = {"A", "B", "C", "D", "E"};
            for (int j = 0; j<strings.length;j++){
                //1. append 字符串的拼接
                sb.append(j).append(strings[j]);
            //3.截取是有返回值的,也不会对原来的造成修改
            String sub = sb.substring(2);

            //4.把从[start,end)部分的字符串替换str
            sb.replace(1,3,"倚天屠龙记");

            //5.把字符串反转
            sb.reverse();

            //6.在某个位置插入某个值
            sb.insert(3,2000);
        }
        //2.toString() 把StringBuilder对象转换为String
        String str = sb.toString();
        System.out.println(str);

        //常用类二
        //Math 这个类提供了一些常用的数学计算方法
        //是一个工具类
//        Math.abs() 计算绝对值
        double d =Math.pow(2,3);
        System.out.println(d);
//        返回一个[0,1)的一个随机数
        double random = Math.random();
//        获取一个从1-100的整数
        int random1 = (int) (Math.random() * 100 +1);
        System.out.println(random1);
        System.out.println(Math.PI);

//        常用类三  时间日期相关
        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        Date date = new Date();
        Date date2 = new Date(timeMillis + 100000);
        System.out.println(date.after(date2));
//        date.getTime(); 获得当前时间的毫秒数
        //时间格式化
        // 2018年7月10日 5:16:22
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(df.format(date));

        String f = "1988年10月25日";
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date parse = format.parse(f);
        System.out.println(parse.getTime());
//        Calendar   random
// 正则表达式
    }
}
