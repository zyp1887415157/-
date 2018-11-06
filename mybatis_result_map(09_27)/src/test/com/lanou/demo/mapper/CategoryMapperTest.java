package com.lanou.demo.mapper;

import com.lanou.demo.entity.GoodsCategory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class CategoryMapperTest {

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
        System.out.println("查询所有类别");
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<GoodsCategory> allSimple = mapper.findAllSimple();
        allSimple.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void test2(){
        System.out.println("查询所有类别与其对应的商品信息");
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<GoodsCategory> all = mapper.findAll();
        all.forEach(System.out::println);
    }

}