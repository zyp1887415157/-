package com.lanou.java.Test.mondle.dao;


import com.lanou.java.Test.mondle.vo.Book;

import java.util.List;

public interface UserDao {
    List<Book> selectAllo() throws Exception;
}
