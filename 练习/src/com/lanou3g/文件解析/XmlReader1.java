package com.lanou3g.文件解析;

import com.lanou3g.IO流.BufferedReader;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class XmlReader1 {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader reader = new java.io.BufferedReader(new FileReader("AA.txt"));
        String line = "";
        Document doc = DocumentHelper.createDocument();
        Element aa = doc.addElement("AA");
        while ((line=reader.readLine())!=null){
            Element name = aa.addElement("name");
            name.setText(line);
        }
        Writer writer = new FileWriter("AA.xml");
        doc.write(writer);
        writer.close();
    }
}
