package com.lanou.demo.dao;

import com.lanou.demo.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public String login(String username) {
        List<User> users = new ArrayList<>();
        User user1 = new User("张三","111");
        User user2 = new User("李四","222");
        users.add(user1);
        users.add(user2);


        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())){
                String password = users.get(i).getPassword();
                return password;
            }
        }
        return null;
    }
}
