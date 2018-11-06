package com.lanou.spring_shiro_test.service;

import com.lanou.spring_shiro_test.entity.UserInfo;
import com.lanou.spring_shiro_test.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImple implements UserInfoService {

    @Resource
    private UserInfoRepository repository;

    @Override
    public UserInfo login(String username, String password) {
        UserInfo userInfo = repository.findByUsername(username);
        if (userInfo != null && userInfo.getPassword().equals(password)) {
            return userInfo;
        }
        return null;
    }
}
