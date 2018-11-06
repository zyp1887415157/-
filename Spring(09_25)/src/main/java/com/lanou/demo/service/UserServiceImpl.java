package com.lanou.demo.service;

import com.lanou.demo.bean.User;
import com.lanou.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserLogin {
    @Autowired
    private UserDao userDao;

    public boolean login(User user) {
        String pwd = userDao.login(user.getUsername());
        if (user.getPassword().equals(pwd)) {
            return true;
        }
        return false;
    }
}
