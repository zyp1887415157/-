package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public Book findBook(String a) {
        //List<Book> books = new ArrayList<>();
        Book book = new Book();
        String sql = "select bid,bname,price,author,image from book where book.bid = ?";

        Connection conn = JDBCUtil.getConn();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, a);
            ResultSet rs = statement.executeQuery();
            rs.next();
//            while (rs.next()) {
                setCategoryParam(book, rs);
//                books.add(book);
//            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    private void setCategoryParam(Book book, ResultSet rs) throws SQLException {
        String bid = rs.getString("bid");
        String author = rs.getString("author");
        String bname = rs.getString("bname");
        double price = rs.getDouble("price");
        String image = rs.getString("image");
        book.setBid(bid)
                .setBname(bname)
                .setPrice(price)
                .setImage(image)
                .setAuthor(author);

    }
}
