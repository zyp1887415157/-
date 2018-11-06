package com.lanou.springbootredis.mapper;

import com.lanou.springbootredis.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleInfoMapper extends JpaRepository<RoleInfo,Long> {
}
