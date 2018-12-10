package com.lanou.bookstore.user.service;


import com.lanou.bookstore.user.dao.RegisterDao;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.JDBCUtil;


public class RegisterService {
    private RegisterDao model = new RegisterDao();

    public boolean register(User user) {
        JDBCUtil.begin();//开启事务
        if (!model.hasThisName(user.getUsername())) {//数据库中没有这个用户名
            JDBCUtil.closeConn();//提交事务
            return model.register(user);//把注册成功的user返回到数据库中

        }
        //JDBCUtil.closeConn();//关闭连接
        return false;
    }
}
