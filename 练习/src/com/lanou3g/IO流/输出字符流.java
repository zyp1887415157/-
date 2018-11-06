package com.lanou3g.IO流;

import java.io.FileWriter;
import java.io.IOException;

public class 输出字符流 {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
             writer = new FileWriter("Text.txt");
            writer.write("锄禾日当午"+"\n");
            writer.write("低头思裤裆");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
