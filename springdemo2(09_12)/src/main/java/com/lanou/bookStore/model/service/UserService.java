package com.lanou.bookStore.model.service;

import com.lanou.bookStore.model.Dao.UserDao;
import com.lanou.bookStore.model.vo.User;

import java.util.List;

public class UserService {
    private UserDao userDao;

    public List<User> showAll() {
        return userDao.selectAll();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
