package com.lanou3g.dao;

import com.lanou3g.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    Student findById(int stuId);

}
