package com.lanou.bookstore.category.domain;

public class Category {
    public String bname;
    public float price;
    public String image;
    public String cid;
    public String bid;
    public String author;

    public String getCid() {
        return cid;
    }

    public Category setCid(String cid) {
        this.cid = cid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public Category setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Category setAuthor(String author) {
        this.author = author;
        return this;
    }


    public String getBname() {
        return bname;
    }

    public Category setBname(String bname) {
        this.bname = bname;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Category setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Category setImage(String image) {
        this.image = image;
        return this;
    }
}
