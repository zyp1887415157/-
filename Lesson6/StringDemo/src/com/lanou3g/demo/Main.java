package com.lanou3g.demo;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liushuqing
 * Created by  18/7/9 下午3:04
 */
public class Main {
    public static void main(String[] args) {
        // 字符串 注:所有的字符串被修改后,都是创建了一个新串,对原字符串都没有影响
        String str = "  java从入a门到放,弃:1.23   ";
        String strz = ";阿斯蒂芬ADSL福克斯;阿迪";
        // 字符串是通过封装char而得到的
        // 1.获取字符串的长度
        int length = str.length();
        System.out.println(strz.length());
        System.out.println(length); // 输出:20

        // 2.获取字符串中某个位置的字符
        char z = strz.charAt(8);
        System.out.println(z);
        char c = str.charAt(4);
        System.out.println(c); // 输出:v

        // 3.获取某个字符在字符串中第一次出现的位置
        int index = str.indexOf('a');
        System.out.println(index);  // 输出:3
        // 查出第二个'a'在字符串中的位置(从第几个位置开始查'a')
        int index1 = str.indexOf('a', index + 1);
        System.out.println(index1);  // 输出:5
//        查出第三个a的位置
        int index8 = str.indexOf('a', index1 + 1);
        System.out.println(index8);
        // 查字符串中某个子串的位置
        int index2 = str.indexOf("入门");
        System.out.println(index2); //输出:5,如果没有该字符串,则输出为-1
        // 从第几个位置开始找"入门"
        int index3 = str.indexOf("入门", 8);
        System.out.println(index3);  // 输出为-1,因为第6个之后没有"入门"

        // 4.判断一个字符串里是否包含某个子串
        boolean a = str.contains("a");
        System.out.println(a);

        // 5.判断一个字符串是否以xxx开始
        boolean j = str.startsWith("j");
        System.out.println(j);

        // 6.判断某个字符串是否以xxx结束的
        boolean b = str.endsWith("入");
        System.out.println(b);

        // 7.检索某个字符在字符串中最后出现的位置
        int index4 = str.lastIndexOf("a");
        System.out.println(index4);// 输出:8

        // 8.将字符串中的某个字符都替换为新的字符
        String replace = str.replace('a', 'A');
        System.out.println(replace);// 输出:jAvA从入门到放弃

        // 原字符串对象没有变化,该方法会返回一个新的字符串对象
        System.out.println(str);// 输出:java从入门到放弃

        // 正则表达式:判断一个字符串是否满足规则
        // 将满足正则表达式的字符串都替换为某个字符串
        String abc = str.replaceAll("\\d", "ABC");
        System.out.println(abc);// 输出:java从入门到放弃ABCABCABC

        // 9.判断字符串是否为空(实质上是在判断字符串的长度,若为0,返回true,反之false)
        String str1;// 只声明了,没有值,不能用
        String str2 = null;// 空指针异常
        String str3 = "";// true
        String str4 = " ";// false
        boolean empty = str4.isEmpty();
        System.out.println(empty);

        // 10.字符串的截取(截取某个子串)   前闭后开:[beginIndex,endIndex)
        String substring = str.substring(1, str.length());// :不包含第5个
        System.out.println(substring);

        // 11.把字符串中的英文都转换为小写字母
//        str.toLowerCase();
        // 把字符串中的英文都转换为大写字母
//        str.toUpperCase();

        // 12.去掉字符串的首尾所有空格
        String trim = str.trim();
        System.out.println(trim);

        // 13.把字符串转换为字节数组
        byte[] bytes = str.getBytes();

        // 14.把字符串转换为字符数组
        char[] chars = str.toCharArray();

        // 15.根据正则表达式把字符串分割为字符串的数组  . 在正则表达式里代表任意字符
        String[] strings = str.split("\\.");
        System.out.println(Arrays.toString(strings));

        // 16.判断两个字符串是否一样  == 比的是内存地址是否一样,而equals比的是内容是否一样
        boolean equals = str.equals("java从入门到放弃");
        System.out.println(equals);

        // 17.忽略大小写判断两个字符串是否一样
        // 比如判断验证码
        String s1 = "hello";
        String s2 = "Hello";
        boolean b1 = s1.equalsIgnoreCase(s2);
        System.out.println(b1);



        /*
        作业:
        1.创建10个类(3条属性,setter&getter),类中再定义一个方法,用来打印所有属性的值
        2.有一个字符串,打印出在字符串中出现的某个字符的下标

         */
        String s = "123";
        int[] arr = new int[s.length()];
        System.out.println(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            arr[i] = s.charAt(i);


            String srcText = "aklsdhf;asdhf;dajs0";
            String findText = "a";
            int num = appearNumber(srcText, findText);
            System.out.println(num);

            String x1 = "alsdjflkasdjflkjadslfk";
            String y1 = "a";
            int count = 3;
            int fromIndex = getFromIndex(x1, y1, count);
            System.out.println(fromIndex);

        }
    }

    //    查看一个字符串中某一元素出现的个数
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;

    }
//        查看一个字符串 第n次出现时的下标数
    private static int getFromIndex(String x1, String y1, Integer count) {
        Matcher slashMatcher = Pattern.compile(y1).matcher(x1);
        int index = 0;
        while (slashMatcher.find()) {
            index++;
            if (index == count) {
                break;
            }
        }
        return slashMatcher.start();
    }

}
