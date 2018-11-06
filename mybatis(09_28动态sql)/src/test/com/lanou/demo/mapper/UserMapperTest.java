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
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("路飞" + i);
            user.setGender("男");
            user.setHeight(1.88f);
            user.setWeight(100f);
            user.setBirthday(Date.valueOf("1999-09-09"));
            users.add(user);
        }
        int i = mapper.addUsers(users);
    }

    @Test
    public void test2() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("索隆");
        user.setId(18);
        int i = mapper.updateOne(user);
    }

    @Test
    public void test3() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(23+i);
            user.setName("山治" + i);
            user.setGender("男");
            user.setHeight(1.88f);
            user.setWeight(100f);
            user.setBirthday(Date.valueOf("1999-09-09"));
            users.add(user);
        }
        int i = mapper.updateUsers(users);
    }


}