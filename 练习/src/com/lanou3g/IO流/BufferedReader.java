package com.lanou3g.IO流;

import com.lanou3g.购物车.Goods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BufferedReader {
    public static void main(String[] args) throws Exception {


       FileReader f = new FileReader("B.txt");
        java.io.BufferedReader reader = new java.io.BufferedReader(f);
        List<Goods> goodsList = new ArrayList<>();
        String line = "";

        while ((line=reader.readLine())!=null){
            String [] split = line.split(",");
            String name = split[0];
            int price = Integer.parseInt(split[1]);
            //应该没有参数
            Goods goods = new Goods(2,"手机",199f);
//            goods.setName(name);
//            goods.setPrice(price);
            goodsList.add(goods);
        }
        f.close();
        reader.close();
        System.out.println(goodsList);

    }
}
