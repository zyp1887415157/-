package com.lanou.demo.mapper;

import com.lanou.demo.entity.Book;

import java.util.List;

public interface BookMapper {

    int insert(Book record);

    int insertSelective(Book book);

    List<Book> selectAll();
}