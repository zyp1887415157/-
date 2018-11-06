package com.lanou.demo.mapper;

import com.lanou.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //进行多添件查询
    List<User> findAllByCondition(Map<String,Object> condition);

    List<User> findAll(Map<String,Object> condition);

    //根据id更新一条数据
    int updateOne (User user);

    // 根据id更新集合中的所有use对象
    default int updateUsers(List<User> users){
        int sum = 0;
        for (User user : users) {
            int i = updateOne(user);
            sum +=i;
        }
        return sum;
    }

    //将集合中的所有id对应的数据都删除掉
    int deleteByUserIds (List<Integer> ids);

    //添加用户
    int addUsers(List<User> users);

}
