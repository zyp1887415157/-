package com.lanou.demo.mapper;

import com.lanou.demo.entity.Goods;
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


public class GoodsMapperTest {

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
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> aLlwithCategory = mapper.findALlwithCategory();
        aLlwithCategory.forEach(System.out::println);
    }



}