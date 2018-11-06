package com.lanou3g.Text;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class text {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document read = reader.read("AA.xml");
        Element rootElement = read.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            String name = next.attributeValue("name");
            System.out.println(name);
            Iterator<Element> iterator1 = next.elementIterator();
            while (iterator1.hasNext()) {
                Element next1 = iterator1.next();
                Element person = next1.addElement("person");
                person.setText("周董");
                String id = next1.elementText("id");
                String name1 = next1.elementText("name");
                System.out.println(id);
                System.out.println(name1);
            }
            Writer writer = new FileWriter("AA.xml");
            read.write(writer);
            writer.close();
        }
    }

}

