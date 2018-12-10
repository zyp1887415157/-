package com.lanou.bookstore.book.domain;

public class Book {
    public String bname;
    public Double price;
    public String image;
    public String cid;
    public String bid;
    public String author;

    public String getBname() {
        return bname;
    }

    public Book setBname(String bname) {
        this.bname = bname;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Book setImage(String image) {
        this.image = image;
        return this;
    }

    public String getCid() {
        return cid;
    }

    public Book setCid(String cid) {
        this.cid = cid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public Book setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }
}
