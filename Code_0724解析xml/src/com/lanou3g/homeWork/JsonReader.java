package com.lanou3g.homeWork;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";

        GoodsContainer.GoodsCell goodsCell =  null;
        List<GoodsContainer.GoodsCell> goodsCells = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            String id1 = split[0];
            String name1 = split[1];
            String price1 = split[2];
            String quantity1 = split[3];
            String unit1 = split[4];
            Goods goods = new Goods();
            goods.setId(Integer.parseInt(id1));
            goods.setName(name1);
            goods.setPrice(Float.parseFloat(price1));

            goods.setUnit(unit1);
            goodsCell = new GoodsContainer.GoodsCell();
            goodsCell.setQuantity(Integer.parseInt(quantity1));
            goodsCell.setGoods(goods);
            goodsCells.add(goodsCell);
        }
        Gson gson = new Gson();
        Writer writer = new FileWriter("json.json");
        String s = gson.toJson(goodsCells);
        writer.write(s);
        writer.close();
    }
}
