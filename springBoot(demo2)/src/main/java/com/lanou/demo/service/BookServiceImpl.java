package com.lanou.demo.service;

import com.github.pagehelper.PageHelper;
import com.lanou.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.demo.entity.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookMapper mapper;

    @Override
    public List<Book> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int addBook(Book book) {
        return mapper.insertSelective(book);
    }

    @Override
    public List<Book> findAllBook(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }
}
