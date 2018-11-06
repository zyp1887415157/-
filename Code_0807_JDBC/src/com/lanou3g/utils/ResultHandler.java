package com.lanou3g.utils;

import com.lanou3g.entity.Student;

import java.sql.Statement;
import java.util.List;

public interface ResultHandler<T> {

    List<T> handle(Statement st, String sql)throws Exception ;

}
