package com.lanou.token_demo.service;

import com.lanou.token_demo.entity.UserInfo;
import com.lanou.token_demo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository repository;

    @Override
    public UserInfo login(String username, String password) {
        UserInfo byUsername = repository.findByUsername(username);
        if (byUsername != null && byUsername.getPassword().equals(password)) {
            return byUsername;
        }

        return null;
    }

    @Override
    public UserInfo findBy(Integer userId) {
        return repository.getOne(userId);
    }
}
