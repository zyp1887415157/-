package com.lanou3g;

import java.io.*;
import java.net.Socket;

public class HttpDemo {
    public static void main(String[] args) throws IOException {

        //应用层协议
        Socket socket = new Socket("www.baidu.com",80);
        OutputStream out = socket.getOutputStream();

        OutputStreamWriter w = new OutputStreamWriter(out);
        w.write("GET www.baidu.com HTTP/1.1\r\n");
        w.write("Host: www.baidu.com\r\n");
        w.write("\r\n");
        w.write("\r\n");
        w.flush();

        InputStream in = socket.getInputStream();
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(r);
        StringBuffer sb = new StringBuffer();
        String line = null;

        while ((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }
}
