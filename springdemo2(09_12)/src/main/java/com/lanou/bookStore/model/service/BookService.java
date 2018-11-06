package com.lanou.bookStore.model.service;

import com.lanou.bookStore.model.Dao.BookDao;
import com.lanou.bookStore.model.vo.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao;


    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> showAll(){
        return bookDao.selectAll();
    }
}
