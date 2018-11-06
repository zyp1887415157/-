package com.lanou3g;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerDemo {
    public static void main(String[] args) throws IOException {


        DatagramSocket ds = new DatagramSocket(6789);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        //把接收到的数据存储到dp对象中
        //阻塞的方法

        while (true){
            ds.receive(dp);
            //读取数据
            byte[] data = dp.getData();
            String str = new String(data,dp.getOffset(),dp.getLength());
            System.out.println("服务端接收到数据: "+str);
        }
    }
}
