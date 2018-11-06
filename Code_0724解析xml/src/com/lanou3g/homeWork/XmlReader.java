package com.lanou3g.homeWork;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;

public class XmlReader {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        Document doc =DocumentHelper.createDocument();
        Element goods = doc.addElement("Goods");
        while ((line=reader.readLine())!=null){
            String[] split = line.split(",");
            String id1 = split[0];
            String name1 = split[1];
            String price1 = split[2];
            String quantity1 = split[3];
            String unit1 = split[4];
            Element good = goods.addElement("Good");
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
        Writer writer = new FileWriter("AA.xml");
        doc.write(writer);
        writer.close();

    }

}
