package com.lanou.springjpa2.Repository;

import com.lanou.springjpa2.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleInfoRepositoryImpl {

    //  引用这个类可以执行sql语句
    @Resource
    private EntityManager entityManager;


    public List<?> queryTest() {

        String sql = "select * from role_info";
        //  创建查询对象  参数（sql语句，返回值类型）
        Query query = entityManager.createNativeQuery(sql, RoleEntity.class);
        // 对象的  getResultList 方法  获取结果集
        List resultList = query.getResultList();

        return resultList;
    }

}
