package com.lanou3g.练习;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

//解析txt放到xml文件中
public class xml_2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("snack-list.txt");
        BufferedReader reader1 = new BufferedReader(reader);
        Document document = DocumentHelper.createDocument();
        Element albumList = document.addElement("Goods");
        String line = "";
        while ((line=reader1.readLine())!=null){
            String[] split = line.split(",");
            Element album = albumList.addElement("Good");
            Element id = album.addElement("id");
            id.setText(split[0]);
            Element name = album.addElement("name");
            name.setText(split[1]);
        }
        Writer writer = new FileWriter("xml2.xml");
        document.write(writer);
        writer.close();
    }

}
