package com.lanou3g;

import com.lanou3g.dao.StudentDao;
import com.lanou3g.dao.impl.StudentDaoImpl;
import com.lanou3g.entity.Student;


import java.util.List;


public class Main {
    public static void main(String[] args)  {

        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList1 = studentDao.findAll();
        System.out.println(studentList1);
        System.out.println("-------------------");

        Student id = studentDao.findById(3);
        System.out.println(id);
    }
}
