package com.lanou3g.文件解析;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class x3 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        Document document = DocumentHelper.createDocument();
        Element Goods = document.addElement("Goods");
        while ((line=reader.readLine())!=null){
            String[] split = line.split(",");
            String id1 = split[0];
            String name1 = split[1];
            String price1 = split[2];
            String quantity1 = split[3];
            String unit1 = split[4];
            Element good = Goods.addElement("Good");
            Element id = good.addElement("id");
            id.setText(id1);
            Element name = good.addElement("name");
            name.setText(name1);
            Element price = good.addElement("price");
            price.setText(price1);
            Element quantity = good.addElement("quantity");
            quantity.setText(quantity1);
            Element unit = good.addElement("unit");
            unit.setText(unit1);
        }
        Writer writer = new FileWriter("BB.xml");
        document.write(writer);
        writer.close();
    }
}
