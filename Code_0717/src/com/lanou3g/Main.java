package com.lanou3g;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "name=手机,price=1999, name=电视,price=5999, name=笔记本,price=3888, name=茶杯,price=19.9";
        String [] split1 = s.split(" ");
        List<Goods> goodsList = new ArrayList<>();
        for (String s1 : split1) {
            String [] split2 = s1.split(",");
            Goods goods = new Goods();
            for (String s2 : split2) {
                String [] split3 = s2.split("=");
                if (split3[0].equals("name")){
                    goods.setName(split3[1]);
                }else if (split3[0].equals("price")){
                    goods.setPrice(Float.parseFloat(split3[1]));
                }
            }
            goodsList.add(goods);
//            goodsList.forEach(System.out::print);
            System.out.println(goods);



        }
    }
}
