package com.lanou3g;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GenerateDemo {

    public static void main(String[] args) {

        //将Document 对象的xml数据写入到文件
        Document doc = DocumentHelper.createDocument();
        //添加一个根元素  名为persons
        Element persons = doc.addElement("persons");
        //在根元素persons下添加persons元素
        Element p1 = persons.addElement("person");
        //在p1后面加一个属性 id=1001
        p1.addAttribute("id", "1001");

        //给p1元素添加子元素,名为name
        Element n1 = p1.addElement("name");
        // 给 p1标签name元素设置值
        n1.setText("张三");

        try {
            Writer w = new FileWriter("out.xml");
            doc.write(w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
