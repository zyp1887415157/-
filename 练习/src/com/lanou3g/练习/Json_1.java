package com.lanou3g.练习;





import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Json_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        List<Good> goods = new ArrayList<>();
        while ((line=reader.readLine())!=null){
            String[] split = line.split(",");
            Good good = new Good();
            good.setId(Integer.parseInt(split[0]));
            good.setName(split[1]);
            good.setPrice(Float.parseFloat(split[2]));
            good.setQuantity(Integer.parseInt(split[3]));
            good.setUnit(split[4]);
            goods.add(good);
        }
        Gson gson = new Gson();
        Writer writer = new FileWriter("Json1.json");
        String s = gson.toJson(goods);
        writer.write(s);
        writer.close();
    }
}
