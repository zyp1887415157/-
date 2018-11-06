package com.lanou3g.IO流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 输入字符流 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("Text.txt");
           char [] chars = new char[20];
            int a = 0;
            while ((a=reader.read(chars))!=-1){
                String date = new String(chars,0,a);
                System.out.println(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
