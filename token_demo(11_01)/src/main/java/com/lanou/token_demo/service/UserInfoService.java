package com.lanou.token_demo.service;

import com.lanou.token_demo.entity.UserInfo;

public interface UserInfoService {

    UserInfo login(String username, String password);

    UserInfo findBy(Integer userId);

}
