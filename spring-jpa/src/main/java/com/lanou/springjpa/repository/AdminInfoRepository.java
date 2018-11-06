package com.lanou.springjpa.repository;

import com.lanou.springjpa.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/adminList")
public interface AdminInfoRepository extends JpaRepository<AdminInfo,Long> {
}
