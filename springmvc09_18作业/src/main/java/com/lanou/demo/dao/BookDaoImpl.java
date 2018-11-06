package com.lanou.demo.dao;

import com.lanou.demo.bean.BookBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public List<BookBean> findAll() {

        List<BookBean> bookBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BookBean bookBean = new BookBean();
            bookBean.setId(i+1);
            bookBean.setName("西游记"+i);
            bookBeans.add(bookBean);
        }
        return bookBeans;
    }
}
