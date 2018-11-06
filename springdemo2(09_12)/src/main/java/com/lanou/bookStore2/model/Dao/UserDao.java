package com.lanou.bookStore2.model.Dao;

import com.lanou.bookStore2.model.vo.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
}
