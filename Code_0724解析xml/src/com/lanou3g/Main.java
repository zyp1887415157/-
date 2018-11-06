package com.lanou3g;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        //解析
        //在特定格式的字符串中提取需要的数据
        //1.获取Document对象
        SAXReader reader = new SAXReader();
        try {
            //1.1 read方法的参数中可以填入File/字符输入流/字节输入流等等
            Document doc = reader.read(new File("album-list.xml"));
            //2.获取根元素
            //Element: 元素
            // root  根
            Element root = doc.getRootElement();
            //3.获取某个元素的子元素的迭代器
            //获取根元素albumList的子元素album的迭代器
            Iterator<Element> iterator = root.elementIterator();
            //遍历所有的album元素
            while (iterator.hasNext()){
                Element albumEle = iterator.next();
                //获取某个元素的某个属性的值
                //获取album元素的name属性的值
                //attribute :属性
                String name = albumEle.attributeValue("name");
                System.out.println(name);
                Iterator<Element> musicIterator = albumEle.elementIterator();
                while (musicIterator.hasNext()){
                    Element musicEle = musicIterator.next();
                    //5.获取某个元素的子元素的文本
                    //获取music元素中的id元素所对应的文本信息
                    String id = musicEle.elementText("id");
                    String musicName = musicEle.elementText("name");
                    String duration = musicEle.elementText("duration");
                    System.out.println(id);
                    System.out.println(musicName);
                    System.out.println(duration);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
