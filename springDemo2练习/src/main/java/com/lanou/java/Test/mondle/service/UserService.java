package com.lanou.java.Test.mondle.service;

import com.lanou.java.Test.mondle.dao.UserDao;
import com.lanou.java.Test.mondle.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<Book> showAll() throws Exception {
        return userDao.selectAllo();
    }
}
