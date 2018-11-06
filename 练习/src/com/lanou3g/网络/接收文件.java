package com.lanou3g.网络;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class 接收文件 {
    public static void main(String[] args) throws Exception {

        ServerSocket socket = new ServerSocket(7788);
        Socket accept = socket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = new FileOutputStream("/Users/dllo/Desktop/UU.jpg");
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
        }

        inputStream.close();
        outputStream.close();
    }
}
