package com.lanou3g;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// 客户端
public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",7890);


        Scanner scanner = new Scanner(System.in);
        OutputStream out = socket.getOutputStream();
        PrintStream p = new PrintStream(out);
        InputStream in = socket.getInputStream();
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader b = new BufferedReader(r);


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
