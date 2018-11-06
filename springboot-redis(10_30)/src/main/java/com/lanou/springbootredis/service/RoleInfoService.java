package com.lanou.springbootredis.service;

import com.lanou.springbootredis.entity.RoleInfo;


import java.util.List;
import java.util.Set;

public interface RoleInfoService {


    List<RoleInfo> findAll();


    RoleInfo findOne( Long roleId);


    RoleInfo addOne(RoleInfo roleInfo);


    boolean deleteOne(Long roleId);

    boolean thumb(Long roleId);

    Set<?> thumbList();
}
