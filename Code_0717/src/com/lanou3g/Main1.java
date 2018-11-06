package com.lanou3g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main1 {


    public static void main(String[] args) {
        String s = "name=手机,price=1999, name=电视,price=5999, name=笔记本,price=3888, name=茶杯,price=19.9";
        String[] split2 = s.split(" ");
        List<Goods1> goodsList = new ArrayList<>();


//        Goods1 goods = new Goods1();


        for (String s1 : split2) {
            String[] split3 = s1.split(",");
            Goods1 goods1 = new Goods1();
            for (String s2 : split3) {
                String[] split4 = s2.split("=");
//                System.out.println(Arrays.toString(split4));
                if (split4[0].equals("name")) {
                    goods1.setName(split4[1]);
                } else if (split4[0].equals("price")) {
                    goods1.setPrice(Float.parseFloat(split4[1]));
                    System.out.println(goods1.getName()+goods1.getPrice());
                }
            }
        }

    }

//    private static void forEach(Iterable<Goods1> iterable) {
//        Iterator<Goods1> iterator = iterable.iterator();
//        List<Goods1> goodsList = new ArrayList<>();
//
//        while (iterator.hasNext()) {
//            Goods1 goods1 = iterator.next();
//            goodsList.add(goods1);
//        }
//    }
}

