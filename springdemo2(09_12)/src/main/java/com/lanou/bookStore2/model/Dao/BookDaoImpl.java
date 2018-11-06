package com.lanou.bookStore2.model.Dao;

import com.lanou.bookStore2.model.vo.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("水浒传",199);
        Book book2 = new Book("三国",299);
        books.add(book1);
        books.add(book2);
        return books;
    }
}
