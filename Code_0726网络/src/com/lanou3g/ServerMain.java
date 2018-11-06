package com.lanou3g;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//  服务端
public class ServerMain {
    public static void main(String[] args) throws IOException {
        //Socket 套接字
        //在java中Socket类可以直接操作TCP协议

        //创建服务端的Socket,设置需要监听的端口号

        ServerSocket server = new ServerSocket(7890);

        //如果监听到有客户端连接端口了,
        //就可以获取到链接过来的Socket对象
        //该方法是一个阻塞的方法
        while (true) {

            System.out.println("服务端已启动,开始监听7890端口");
            System.out.println("等待客户端连接");
            Socket socket = server.accept();

            System.out.println("客户端已连接,开始读取客户端发送过来的数据");
            //获取到输入流   客户端发送过来的数据
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //获取输入流  用来给客户端发送数据
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter w = new OutputStreamWriter(out);
            PrintWriter p = new PrintWriter(w);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String word = reader.readLine();
                System.out.println("客户端说:\n"+word);
                if ("bye".equals(word)){
                    break;
                }
                System.out.println("请输入");
                String s = scanner.nextLine();
                p.println(s);//自动带换行
                p.flush();
                System.out.println("服务端回复客户端");

            }

        }
    }
}
