package com.lanou3g.文件解析;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;

public class X1 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read("album-list.xml");
            //获取根元素 albumList
            Element rootElement = read.getRootElement();
            //获取根元素子元素的迭代器  album
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element next = iterator.next();
                String name = next.attributeValue("name");
                System.out.println(name);
                Iterator<Element> iterator1 = next.elementIterator();
                while (iterator1.hasNext()){
                    Element next1 = iterator1.next();
                    String id = next1.elementText("id");
                    String name1 = next1.elementText("name");
                    String duration = next1.elementText("duration");
                    String person = next1.elementText("person");
                    Element wife = next1.addElement("Wife");
                    wife.setText("昆凌");
                    String wife1 = next1.elementText("Wife");
                    System.out.println(id);
                    System.out.println(name1);
                    System.out.println(duration);
                    System.out.println(person);
                    System.out.println(wife1);
                }
            }
            Writer writer = new FileWriter("album-list.xml");
            read.write(writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
