package com.lanou.demo;

import com.lanou.demo.entity.Person;
import com.lanou.demo.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        //获取sqlSessionFactory对象
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);


    }

    @Test
    public void test() {
        SqlSession sqlSession = sessionFactory.openSession();
        //执行在mapper文件中定义的某个statement
//        List<Person> persons = sqlSession.selectList("person.findAll");
//        persons.forEach(System.out::println);

//        Map<String,Object> params = new HashMap<>();
//        params.put("id",1);
//        params.put("name","张三")
//        Person person = sqlSession.selectOne("person.findByid", params);

//        Person person = new Person();
//        person.setName("刘德华");
//        person.setId(2);
//        Person person = sqlSession.selectOne("person.findByid", person);

        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> all = mapper.findAll();

        Person p = new Person();
        p.setId(1);
        p.setName("张三");
        Person person = mapper.findByid(p);
        all.forEach(System.out::println);
        System.out.println(person);

        Person person1 = new Person();
        person1.setName("简介明");
        person1.setAge(25);
        int i = mapper.addOne(person1);
    }
}
