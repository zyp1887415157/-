package com.lanou3g.网络;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) throws Exception {
       UdpClientRunnable udpClientRunnable = new UdpClientRunnable();
       Thread thread = new Thread(udpClientRunnable);
       thread.start();
    }
}
