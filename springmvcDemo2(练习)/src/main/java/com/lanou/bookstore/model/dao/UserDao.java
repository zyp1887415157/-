package com.lanou.bookstore.model.dao;

import com.lanou.bookstore.model.vo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    String selectPwdByName(String username);
    int insertUser(User user);
}
