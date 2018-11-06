package com.lanou3g.IO流;

import java.io.*;

public class CopyTest {
    public static void main(String[] args) throws Exception {
        String oldPath = "/Users/dllo/Desktop/图片/219995DD2C8E861519B4645EFE249EF0.jpg";
        String newPath1 = "/Users/dllo/Desktop/考试/123/abc";
        String newPath2 = "/Users/dllo/Desktop/考试/123/abc/A.jpg";

        File file1 = new File(oldPath);
        File file2 = new File(newPath1);
        File file3 = new File(newPath2);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        file2.mkdirs();
        file3.createNewFile();
        fis = new FileInputStream(file1);
        fos = new FileOutputStream(file3);
        int line = 0;
        byte[] bytes = new byte[1024];
        while ((line = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, line);
        }
        fis.close();
        fos.close();
    }
}
