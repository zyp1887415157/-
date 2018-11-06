package com.lanou.bookStore2.controller;

import com.lanou.bookStore2.model.service.BookService;
import com.lanou.bookStore2.model.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class BookAction {
    @Resource(name = "bookService")
    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext6.xml");

        BookAction action = (BookAction) context.getBean("bookAction");
        List<Book> list = action.bookService.showAll();
        System.out.println(list);
    }
}
