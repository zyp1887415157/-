package com.lanou3g.网络;

import java.net.*;
import java.util.Scanner;

public class UdpClientRunnable implements Runnable {


//    Scanner scanner = new Scanner(System.in);
//    DatagramSocket socket;
//
//    {
//        try {
//            socket = new DatagramSocket();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            System.out.println("请输入");
//            String s = scanner.nextLine();
//            byte [] bytes = s.getBytes();
//            InetAddress address = null;
//            try {
//                address = InetAddress.getByName("172.16.31.255");
//                DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,6789);
//                socket.send(packet);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

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
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            try {
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,7788);
                socket.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
