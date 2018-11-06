package com.lanou.demo.bean;

import com.lanou.demo.validate.BookAdd;
import com.lanou.demo.validate.BookUpdateValidator;
import com.lanou.demo.validator.IdCard;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.sql.Date;

public class Book {

    //这条属性，在更新书本的方法中是需要校验的
    //但是在新增书本的方法中，是不需要的
    //groups是添加的标记
    @NotNull(message = "id不能为空",groups = {BookUpdateValidator.class})
    private Integer id;

    @IdCard(message = "身份证输入不合法")
    private String idCardNumber;

    @NotBlank(message = "书名不能为空",groups ={BookAdd.class})
    private String bookName;

    @NotBlank(message = "作者不能为空")
    private String author;

    @Min(value = 0, message = "价钱必须大于0")
    @Digits(integer = 3, fraction = 2, message = "设置的价钱不合理")
    @NotNull(message = "价钱不能为空")
    private Float price;

    @NotNull(message = "时间不能为空")
    //  代表这个时间必须是过去的时间
    @Past(message = "时间必须是过去的时间")
    //  @Future  (时间必须是未来的时间)
    private Date publishDate;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
