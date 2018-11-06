package com.lanou3g.练习;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

public class Json_2 {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Good>>() {
        }.getType();
        FileReader reader = new FileReader("Json1.json");
        PrintWriter writer = new PrintWriter(new FileWriter("Json2.txt"));
        List<Good> goods = gson.fromJson(reader, type);
        for (Good good : goods) {
            int id = good.getId();
            String name = good.getName();
            float price = good.getPrice();
            int quantity = good.getQuantity();
            String unit = good.getUnit();
            writer.write(id + "," + name + "," + price + "," + quantity + "," + unit + "\n");
        }
        writer.close();
        reader.close();
    }
}
