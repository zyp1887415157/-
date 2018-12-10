package com.lanou.bookstore.cart.domain;

import com.lanou.bookstore.book.domain.Book;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    public Book book;
    public int count;

    public Book getBook() {
        return book;
    }

    public CartItem setBook(Book book) {
        this.book = book;
        return this;
    }

    public int getCount() {
        return count;
    }

    public CartItem setCount(int count) {
        this.count = count;
        return this;
    }
    public double getSubtotal(){//小计方法
        BigDecimal d1 = new BigDecimal(book.getPrice()+"");
        BigDecimal d2 = new BigDecimal(count+"");
        return d1.multiply(d2).doubleValue();
    }
}
