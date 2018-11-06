package com.lanou.demo.mapper;


import com.lanou.demo.entity.Order;
import com.lanou.demo.entity.OrderMoney;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class OrderMapperTest {

    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sessionFactory.openSession(true);

    }
    @Test
    public void test1(){

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void test2(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.findByid(2);
        System.out.println(order);
    }

    @Test
    public void test3(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderMoney> allWithMoney = mapper.findAllWithMoney();
        allWithMoney.forEach(System.out::println);
    }



}