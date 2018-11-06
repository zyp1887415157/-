package com.lanou.bookStore2.model.service;

import com.lanou.bookStore2.model.Dao.BookDao;
import com.lanou.bookStore2.model.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookService {
    @Resource(name = "bookDaoImpl")
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
