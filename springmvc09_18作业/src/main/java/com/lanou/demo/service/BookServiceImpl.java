package com.lanou.demo.service;

import com.lanou.demo.bean.BookBean;
import com.lanou.demo.dao.BookDao;
import com.lanou.demo.dao.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<BookBean> findAll() {
        List<BookBean> all = bookDao.findAll();
        return all;
    }
}
