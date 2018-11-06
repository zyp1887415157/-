package com.lanou.bookStore.model.Dao;

import com.lanou.bookStore.model.vo.User;

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
