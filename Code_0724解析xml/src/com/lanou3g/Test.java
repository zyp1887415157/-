package com.lanou3g;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read("album-list.xml");
            Element rootElement = doc.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element albumEle = iterator.next();
                Iterator<Element> musicIterator = albumEle.elementIterator();
                while (musicIterator.hasNext()) {
                    Element musicEle = musicIterator.next();
                    if (musicEle.element("person")==null){
                        Element person = musicEle.addElement("person");
                        person.setText("周杰伦");
                    }
                }
            }
            Writer w = new FileWriter("album-list.xml");
            doc.write(w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
