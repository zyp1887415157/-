package com.lanou.spring_shiro_test.repository;

import com.lanou.spring_shiro_test.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    
    UserInfo findByUsername (String username);
}
