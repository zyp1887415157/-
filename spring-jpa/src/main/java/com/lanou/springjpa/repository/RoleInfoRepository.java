package com.lanou.springjpa.repository;

import com.lanou.springjpa.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource(path = "roleList")
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {

    // 网址路径上在roleList后加上search  roleList/search/findByName
    @RestResource(path = "findByName")
    List<RoleInfo> findByNameContains(@Param("name") String name);

    @RequestMapping(path = "findByIdBetween")
    List<RoleInfo> findByRoleIdBetween(@Param("start") Long start,
                                       @Param("end") Long end);


}
