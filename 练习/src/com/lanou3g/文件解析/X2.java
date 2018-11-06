package com.lanou3g.文件解析;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class X2 {
    public static void main(String[] args) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element albumList = document.addElement("albumList");
        Element album = albumList.addElement("album");
        album.addAttribute("name", "周杰伦");
        Element music = album.addElement("music");
        Element id = music.addElement("id");
        id.setText("1");
        Element name = music.addElement("name");
        name.setText("告白气球");

        Writer writer = new FileWriter("AA.xml");
        document.write(writer);
        writer.close();
    }
}
