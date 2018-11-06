package com.lanou.springjpa2.Repository;

import com.lanou.springjpa2.Repository.temp.RoleEx;
import com.lanou.springjpa2.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface RoleInfoRepository extends JpaRepository<RoleEntity, Long> {


    //(原生的方法) 另一种  方法  查询类的
    @Query("select role from RoleEntity role")
    List<RoleEntity> reoleTest();

    // 另一种方法
    @Query(value = "select * from role_info", nativeQuery = true)
    List<RoleEntity> roles();

    @Query(value = "select role_id as roleId,\n" +
            "       role_info.name as roleName,\n" +
            "       COUNT(role_module.temp_module_id) as moduleCount\n" +
            "from role_info\n" +
            "       left join role_module on role_id = role_module.temp_role_id\n" +
            "group by role_id",nativeQuery = true)
    List<RoleEx> roleGroup();


    List<?> queryTest();



}
