package com.lanou.bookstore.user.service;


import com.lanou.bookstore.user.dao.LoginDao;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.JDBCUtil;


public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public User login(String username, String password) {
        try {
            if (username == null || password == null) {
                return null;
            }
            if (!loginDao.canLogin(username, password)) {
                return null;
            }
            User user = loginDao.login(username,password);
            return user;
        }finally {
            JDBCUtil.closeConn();
        }

    }

}
