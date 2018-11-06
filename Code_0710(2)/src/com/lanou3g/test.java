package com.lanou3g;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        //时间日期相关
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));

        String data = "2018-07-10 07:09:35";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = simpleDateFormat.parse(data);
        System.out.println(parse.getTime());

        //Math 类
        double d = Math.random();
        System.out.println((int)( d * 100 +1));
        double d1 = Math.pow(2,4);
        System.out.println(d1);

        //常用类
        StringBuilder sb  = new StringBuilder();
        String[] strings = {"A","B","C","D","E"};
        for (int i = 0;i<strings.length;i++){
            sb.append(i).append(strings[i]);
        }
        System.out.println(sb.toString());

        String sub = sb.substring(2);
        System.out.println(sub);
        sb.replace(2,4,"JAVA");
        System.out.println(sb);
        sb.insert(3,"QQ");
        System.out.println(sb);


        Calendar cal = Calendar.getInstance();
        System.out.println("DAY_OF_WEEK:" + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_MONTH:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: "+cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("YEAR: "+cal.get(Calendar.YEAR));
        System.out.println("MONTH: "+cal.get(Calendar.MONTH));
        System.out.println("HOUR_OF_DAY : "+cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE : "+cal.get(Calendar.MINUTE));
        System.out.println("SECOND : "+cal.get(Calendar.SECOND));
//         将日期向后推一天
        cal.add(Calendar.DATE,1);
        System.out.println(cal.getTime());
//         将日期向前推一天
        cal.add(Calendar.DATE,-1);
        System.out.println(cal.getTime());


    }
}
