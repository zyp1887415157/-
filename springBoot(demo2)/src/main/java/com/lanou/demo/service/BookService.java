package com.lanou.demo.service;

import com.lanou.demo.entity.Book;
import java.util.List;

public interface BookService {

    List<Book> selectAll();

    int addBook(Book book);

    List<Book> findAllBook(int pageNum, int pageSize);
}
