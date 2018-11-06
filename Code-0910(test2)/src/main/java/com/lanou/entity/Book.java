package com.lanou.entity;

public class Book {
    private int bid;
    private String bname;
    private double price;
    private String author;
    private String image;
    private char cid;


    @Override
    public String toString() {
        return "com.lanou.entity.Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", cid=" + cid +
                '}';
    }

    public Book(int bid, String bname, double price, String author, String image) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public char getCid() {
        return cid;
    }

    public void setCid(char cid) {
        this.cid = cid;
    }
}
