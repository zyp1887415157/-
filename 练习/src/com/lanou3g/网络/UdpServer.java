package com.lanou3g.网络;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws Exception {

//        System.out.println("服务端上线");
//        DatagramSocket socket = new DatagramSocket(6789);
//        byte[] bytes = new byte[1024];
//        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
//
//        while (true){
//            socket.receive(packet);
//            byte[] data = packet.getData();
//            String str = new String(data,packet.getOffset(),packet.getLength());
//            System.out.println("客户端说"+str);

        System.out.println("服务端上线了");
        DatagramSocket socket = new DatagramSocket(7788);
        byte [] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

        while (true){
            socket.receive(packet);
            byte[] data = packet.getData();
            String str = new String(data,packet.getOffset(),packet.getLength());
            System.out.println("客户端说"+str);
        }

    }
}
