package com.lanou3g.点名;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        Frame f = new Frame("随机");
        f.setVisible(true);
        randomStudent((ArrayList<Student>) read());
    }
    public static List<Student> read() throws Exception {
        FileReader reader = new FileReader("B.txt");
        BufferedReader reader1 = new BufferedReader(reader);
        String line = "";
        List<Student> students = new ArrayList<>();
        while ((line = reader1.readLine()) != null) {
            String[] split = line.split(",");
            Student student = new Student();
            student.setName(split[0]);
            student.setAge(Integer.parseInt(split[1]));
            students.add(student);
        }
//        students.forEach(System.out::println);
        return students;
    }

    public static void printStudent(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("姓名" + student.getName() + "年龄" + student.getAge());
        }
    }

    public static void randomStudent(ArrayList<Student> students) {
        int index = new Random().nextInt(students.size());
        Student student = students.get(index);
        System.out.println("被随机点名的同学:" + student.getName() + ", 年龄" + student.getAge());
    }
}
