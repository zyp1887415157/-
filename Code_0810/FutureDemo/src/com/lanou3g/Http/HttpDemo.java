package com.lanou3g.Http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpDemo {
    public static void main(String[] args) throws IOException {

        //okHttp  发送Http请求

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533903197388&di=ed46d40502eeab2690c4c4e163876c23&imgtype=0&src=http%3A%2F%2Fi.shangc.net%2F2018%2F0626%2F20180626012039209.jpg";
        /*
        发送http请求步骤:
        1.请求地址
        2.指定请求方法(get/Post)
          2.1 get:一般用来向浏览器请求数据
          2.2 post: 一般用来发送数据
        3.设置请求头  简单的请求可以省略
        4.设置请求体   get请求可以没有
        5.发送请求
        6.处理响应
         */

        //建造者模式
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)  //请求地址
                .get()  //指定请求方法
//                .headers()  //请求头
                .build();
        Response resp = client.newCall(request).execute(); // 发送请求  获取响应

        //处理响应
        InputStream inputStream = resp.body().byteStream();
        //文件总大小
        long size = resp.body().contentLength();
        byte[] bytes = new byte[1024*1024];
        double currentSize = 0;
        FileOutputStream fos = new FileOutputStream("girl.jpg");
        int length = 0;
        long millis = System.currentTimeMillis();
        int sum = 0;
        while ((length = inputStream.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
            currentSize += length;
            System.out.println("进度:" + (currentSize / size * 100 + "%"));
            long l = System.currentTimeMillis() - millis;
            sum +=l;
        }
        fos.close();
        inputStream.close();
        System.out.println("耗时"+sum);
    }
}
