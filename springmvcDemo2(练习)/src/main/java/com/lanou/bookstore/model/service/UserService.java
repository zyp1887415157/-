package com.lanou.bookstore.model.service;


import com.lanou.bookstore.model.dao.UserDaoImpl;
import com.lanou.bookstore.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDaoimpl;

    public List<User> findAll(){
        List<User> users = userDaoimpl.findAll();
        return users;
    }

    public boolean login(User user){
        String pwd = userDaoimpl.selectPwdByName(user.getUsername());
        if (user.getPassword().equals(pwd)){
            return true;
        }
        return false;
    }

    public boolean register(User user){
        if (userDaoimpl.insertUser(user)>0){
            return true;
        }
        return false;
    }
}
