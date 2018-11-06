package com.lanou.bookStore.controller;

import com.lanou.bookStore.model.service.BookService;
import com.lanou.bookStore.model.vo.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookAction {

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");

        BookAction action = (BookAction) context.getBean("bookAction");
        List<Book> list = action.bookService.showAll();
        System.out.println(list);
    }
}
