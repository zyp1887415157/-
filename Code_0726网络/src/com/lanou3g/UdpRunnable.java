package com.lanou3g;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpRunnable implements Runnable {

    Scanner scanner = new Scanner(System.in);


    DatagramSocket socket;

    {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true){
            System.out.println("请输入");
            String a = scanner.nextLine();
            byte[] bytes1 = a.getBytes();
//        byte[] bytes = "UDP,你好啊".getBytes();
            //本机的IP地址
            InetAddress address = null;
            try {
                address = InetAddress.getByName("172.16.31.255");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            //构建数据包
            DatagramPacket dp = new DatagramPacket(bytes1,bytes1.length,address,6789);
            try {
                socket.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
