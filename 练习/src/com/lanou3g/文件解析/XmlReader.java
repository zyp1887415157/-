package com.lanou3g.文件解析;

import com.google.gson.Gson;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlReader {
    public static void main(String[] args) throws Exception{
        SAXReader reader = new SAXReader();
        Document read = reader.read(new File("album-list.xml"));
        // 获取根元素albumList
        Element root = read.getRootElement();
        //获取album
        Iterator<Element> iterator = root.elementIterator();

        Album album = new Album();
        List<Album> albumList = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();

        while (iterator.hasNext()){
            Element albumEle = iterator.next();
            String name = albumEle.attributeValue("name");
            album.setAlbumName(name);
            albumList.add(album);
            System.out.println(name);
            Iterator<Element> iterator1 = albumEle.elementIterator();
            while (iterator1.hasNext()){
                Element musicEle = iterator1.next();
                String id = musicEle.elementText("id");
                String musicName = musicEle.elementText("name");
                String duration = musicEle.elementText("duration");
                Music music = new Music();
                music.setMusicName(musicName);
                music.setDuration(Integer.parseInt(duration));
                musicList.add(music);
//                musicList = new ArrayList<>();
                album.setMusicList(musicList);
                System.out.println(id);
                System.out.println(musicName);
                System.out.println(duration);
            }
            Gson gson = new Gson();
            Writer writer = new FileWriter("CC.json");
            String s = gson.toJson(albumList);
            writer.write(s);
            writer.close();
        }
    }
}
