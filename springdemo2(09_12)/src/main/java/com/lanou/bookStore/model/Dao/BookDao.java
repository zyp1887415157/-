package com.lanou.bookStore.model.Dao;

import com.lanou.bookStore.model.vo.Book;

import java.util.List;

public interface BookDao {
     List<Book> selectAll();
}
