package com.lanou.bookStore2.model.Dao;

import com.lanou.bookStore2.model.vo.Book;

import java.util.List;

public interface BookDao {
     List<Book> selectAll();
}
