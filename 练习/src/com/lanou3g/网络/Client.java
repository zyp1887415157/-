package com.lanou3g.网络;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8899);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader b = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter p = new PrintWriter(new OutputStreamWriter(outputStream));
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入");
            String next = scanner.next();
            p.println(next);
            p.flush();
            String word = b.readLine();
//            System.out.println("客户端说"+word);
            System.out.println("服务端说:\n"+word);
            System.out.println("客户端开始回复服务端");
        }
    }
}
