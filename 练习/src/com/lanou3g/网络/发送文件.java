package com.lanou3g.网络;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class 发送文件 {
    public static void main(String[] args) throws Exception {


        Socket socket = new Socket("127.0.0.1", 7788);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = new FileInputStream("/Users/dllo/Desktop/图片/未命名文件夹/作业.png");
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
        }
        inputStream.close();
        outputStream.close();


    }
}
