package com.lanou.bookStore2.model.service;

import com.lanou.bookStore2.model.Dao.UserDao;
import com.lanou.bookStore2.model.vo.User;

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
