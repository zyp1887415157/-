package com.lanou.demo.dao;

import com.lanou.demo.bean.BookBean;

import java.util.List;

public interface BookDao {

    List<BookBean> findAll();
}
