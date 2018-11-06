package com.lanou.spring_shiro_test.service;

import com.lanou.spring_shiro_test.entity.UserInfo;

public interface UserInfoService {

    UserInfo login(String username, String password);
}
