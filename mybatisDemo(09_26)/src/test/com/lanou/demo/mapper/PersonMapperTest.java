package com.lanou.demo.mapper;

import com.lanou.demo.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class PersonMapperTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        //获取sqlSessionFactory对象
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);

    }

    @Test
    public void test(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        System.out.println(mapper.getClass());
        Person person = new Person();
        person.setName("简介名");
        person.setAge(33);
        int i = mapper.addOne(person);
        List<Person> all = mapper.findAll();
        all.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setId(2);
        person.setName("新人");
        person.setAge(38);
        mapper.updateOne(person);
        sqlSession.commit();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("路飞");
        person.setAge(33);
        mapper.addOne(person);
        System.out.println(person);
        sqlSession.commit();

    }

}