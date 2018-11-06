package com.lanou.bookStore.model.Dao;

import com.lanou.bookStore.model.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("水浒传",199);
        Book book2 = new Book("三国",299);
        Book book3 = new Book("西游记",399);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }
}
