package com.lanou.bookStore.model.Dao;

import com.lanou.bookStore.model.vo.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
}
