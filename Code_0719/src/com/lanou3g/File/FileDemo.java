package com.lanou3g.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        //文件类
        /*

        路径
        绝对路径:从硬盘根目录开始一直到某个文件的路径
        /Users/dllo/Desktop/2.jpg
        相对路径: 相对于某个文件夹定位文件的路径

         */

        String path = "/Users/dllo/Desktop/A.txt";
        File file = new File(path);
        //名字
        System.out.println(file.getName());
        //上层目录的路径
        System.out.println(file.getParent());
        //自身路劲
        System.out.println(file.getPath());
        //判断文件是否存在
        System.out.println(file.exists());
        //判断是否是文件
        System.out.println(file.isFile());
        //判断是否是文件夹
        System.out.println(file.isDirectory());
        //列出该目录下的所有文件
        File[] files = file.listFiles();
        try {
            //新建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件的大小,单位是字节 Byte
        System.out.println(file.length());
        //创建最后一级文件夹
        file.mkdir();
        //创建多级文件夹
        file.mkdirs();
        //列出桌面上的所有文件和文件夹
        File file1 = new File("/Users/dllo/Desktop/");
        //获取该文件夹下的所有文件
        File[] files1 = file1.listFiles();
        for (File file2 : files1) {
            //文件名称
            System.out.println(file2.getName());
            //判断是不是文件
            System.out.println(file2.isFile());
            //获取文件大小
            System.out.println(file2.length() + "KB");
        }
        System.out.println("--------------------------");

        //列出桌面包括子文件夹的所有图片名称/大小
        list(new File("/Users/dllo/Desktop/图片"));
    }

    public static void list(File file) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("Text.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.isFile()) {
            //打印file信息
            //文件后缀名
            if (file.getName().endsWith(".png")) {
                try {
                    writer.write("文件名:" + file.getName() + "文件大小" + file.length() + "KB" + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
//                System.out.printf("文件名: %s 文件大小: %s \n",file.getName(),file.length()+"KB");
            }
//            System.out.println(file.getPath());
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                list(file1);

            }
        }
    }
}
