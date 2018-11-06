package com.lanou3g.IO流;

import java.io.FileInputStream;

public class 输入字节流 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("AA.txt")) {
            byte[] bytes = new byte[1024];
            int a = 0;
            while ((a = fis.read(bytes))!=-1){
                String data = new String(bytes,0,a);
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
