package com.lanou.test;

import com.lanou.entity.Book;
import com.lanou.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(resource);
    }

    @Test
    public void test1() {
        SqlSession sqlSession = sessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = mapper.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
