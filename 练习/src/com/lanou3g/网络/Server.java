package com.lanou3g.网络;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8899);
        while (true) {
            Socket accept = socket.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter p = new PrintWriter(new OutputStreamWriter(outputStream));
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
