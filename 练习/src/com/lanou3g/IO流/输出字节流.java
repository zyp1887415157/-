package com.lanou3g.IO流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 输出字节流 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("AA.txt")) {
            String str = "锄禾日当午";
            fos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
