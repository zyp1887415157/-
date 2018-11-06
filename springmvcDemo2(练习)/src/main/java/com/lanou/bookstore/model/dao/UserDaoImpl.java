package com.lanou.bookstore.model.dao;

import com.lanou.bookstore.model.vo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<>();
    @Override
    public List<User> findAll() {
        User user = new User("张三","111");
        User user1 = new User("李四","222");
        users.add(user);
        users.add(user1);
        return users;
    }

    @Override
    public String selectPwdByName(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())){
                return users.get(i).getPassword();
            }
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        users.add(user);
        return 1;
    }


}
