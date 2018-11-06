package com.lanou.demo.mapper;

import com.lanou.demo.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class PersonMapperTest {

    private SqlSessionFactory sessionFactory;




    @Before
    public void init() throws IOException {
        //获取sqlSessionFactory对象
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);

    }

    @Test
    public void findAll(){
       SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> all = mapper.findAll();
        all.forEach(System.out::println);
    }


    @Test
    public void addOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("大哥");
        person.setAge(44);
        int i = mapper.addOne(person);
        sqlSession.commit();
    }

    @Test
    public void updateOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("刘德华");
        int i = mapper.updateOne(person);
        sqlSession.commit();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = sessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int delete = mapper.delete(4);
        sqlSession.commit();
    }




}