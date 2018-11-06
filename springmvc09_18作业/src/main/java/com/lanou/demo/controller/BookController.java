package com.lanou.demo.controller;

import com.lanou.demo.bean.BookBean;
import com.lanou.demo.service.BookService;
import com.lanou.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/{path}")
    public String book(@PathVariable String path) {
        return path;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<BookBean> findAll() {
        List<BookBean> all = bookService.findAll();
        return all;
    }
}
