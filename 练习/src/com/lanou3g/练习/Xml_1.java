package com.lanou3g.练习;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
//解析xml文件
public class Xml_1 {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document read = reader.read(new File("BB.xml"));
        Element rootElement = read.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();//good
        while (iterator.hasNext()){
            Element next = iterator.next();
            String id = next.elementText("id");
            String name = next.elementText("name");
            System.out.println(id);
            System.out.println(name);
        }
    }
}
