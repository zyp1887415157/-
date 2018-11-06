package com.lanou3g.Http下载文件;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class HttpDemo {
    public static void main(String[] args) throws IOException {
        String ur = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533903197388&di=ed46d40502eeab2690c4c4e163876c23&imgtype=0&src=http%3A%2F%2Fi.shangc.net%2F2018%2F0626%2F20180626012039209.jpg";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(ur).get().build();
        Call call = client.newCall(request);
        Response response = call.execute();
        InputStream inputStream = response.body().byteStream();
        OutputStream outputStream = new FileOutputStream("Girl.jpg");
        long l = response.body().contentLength();
        long timeMillis = System.currentTimeMillis();
        int line = 0;
        int sum = 0;
        double count = 0;
        byte[] bytes = new byte[1024];
        System.out.println("文件大小为:" + l);
        while ((line = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
            long l1 = System.currentTimeMillis() - timeMillis;
            sum += l1;
            count += line;
            System.out.println("下载了" + (count / l * 100 + "%"));
        }
        System.out.println("总耗时为" + sum);
        inputStream.close();
        outputStream.close();
    }
}
