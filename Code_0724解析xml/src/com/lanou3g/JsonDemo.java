package com.lanou3g;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //Json 格式
        /*
        Json  类型的数据由两种数据类型组成:
        1:{}  括起来的部分叫做对象
        2:[]  括起来的部分叫做数组或集合

        对象中的数据,都是以键值对的形式保存的
        key   一定是字符串,value  可以是数字/字符串/boolean/对象/null/数组

        解析Json数据常用三种框架:   用哪个都行
        1:jackson
        2:gson
        3:fastJson   阿里巴巴出品的
         */

        //解析
        //1.创建gson对象
        Gson gson = new Gson();
//        //2.判断gson数据最外层的数据类型,确定解析的结果的数据类型([] 在最外层)
//        Type type = new TypeToken<List<Album>>(){}.getType();
//        //3.开始解析
//        Reader r = new FileReader("album-list.json");
//        List<Album> albumList = gson.fromJson(r,type);
//
//        for (Album album : albumList) {
//            System.out.println(album.getAlbumName());
//            List<Music> musicList = album.getMusicList();
//            for (Music music : musicList) {
//                System.out.println(music.getMusicName());
//                System.out.println(music.getDuration());
//            }
//        }

        //解析最外层是{}的情况
        //1.创建gson对象
        //2.分析结果类型
        //3.解析
        Reader reader = new FileReader("album.json");
        Album album = gson.fromJson(reader,Album.class);
        System.out.println("-----------------");
        System.out.println(album.getAlbumName());
        for (Music music : album.getMusicList()) {
            System.out.println(music);
        }

        //将对象序列化成字符串
        String s = gson.toJson(album.getMusicList());

        System.out.println(s);
    }
}
