package com.lanou3g;

import java.net.*;
import java.util.Scanner;

public class UdpClientDemo {
    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        DatagramSocket socket = new DatagramSocket();

        UdpRunnable udpRunnable = new UdpRunnable();
        Thread thread = new Thread(udpRunnable);
        thread.start();

//        while (true){
//            System.out.println("2请输入");
//            String a = scanner.nextLine();
//            byte[] bytes1 = a.getBytes();
////        byte[] bytes = "UDP,你好啊".getBytes();
//            //本机的IP地址
//            InetAddress address = InetAddress.getByName("172.16.31.255");
//            //构建数据包
//            DatagramPacket dp = new DatagramPacket(bytes1,bytes1.length,address,6789);
//            socket.send(dp);
//        }

    }
}
