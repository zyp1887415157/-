package com.lanou.demo.mapper;


import com.lanou.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sessionFactory.openSession(true);

    }

    @Test
    public void test1() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allWithPriceByUser = mapper.findAllWithPriceByUser();
        allWithPriceByUser.forEach(System.out::println);
    }

    @Test
    public void test2() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> condition = new HashMap<>();
        condition.put("userName", "%小%");
        condition.put("gender", "女");
        condition.put("minHeight", 1.80);

        System.out.println("第1次查询");
        SqlSession sqlSession1 = sessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        List<User> allByCondition1 = mapper1.findAllByCondition(condition);
        allByCondition1.forEach(System.out::println);
        sqlSession1.close();

        System.out.println("第2次查询");
        List<User> allByCondition2 = mapper.findAllByCondition(condition);
        allByCondition2.forEach(System.out::println);
    }

    @Test
    public void test3() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> condition = new HashMap<>();
        condition.put("userName", "%小%");
        condition.put("gender", "女");
        condition.put("minHeight", 1.80);

        List<User> all = mapper.findAll(condition);
        all.forEach(System.out::println);
    }

    @Test
    public void test4() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(6);
        user.setHeight(3.00F);
        user.setWeight(180F);
        int i = mapper.updateOne(user);
    }

    @Test
    public void test5() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        int i = mapper.deleteByUserIds(integers);
    }

    @Test
    public void test7() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(18+i);
            user.setName("孙悟空"+i);
            user.setGender("女");
            user.setHeight(1.88f);
            user.setWeight(100f);
            user.setBirthday(Date.valueOf("1999-09-09"));
            users.add(user);
        }
        int i = mapper.updateUsers(users);
        System.out.println(i);
    }

    @Test
    public void test6() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("孙悟空"+i);
            user.setGender("男");
            user.setHeight(1.88f);
            user.setWeight(188f);
            user.setBirthday(Date.valueOf("1999-09-09"));
            users.add(user);
        }
        int i = mapper.addUsers(users);
    }
}