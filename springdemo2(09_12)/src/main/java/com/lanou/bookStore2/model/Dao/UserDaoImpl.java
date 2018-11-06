package com.lanou.bookStore2.model.Dao;

import com.lanou.bookStore2.model.vo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        User user = new User("战三");
        users.add(user);
        return users;
    }
}
