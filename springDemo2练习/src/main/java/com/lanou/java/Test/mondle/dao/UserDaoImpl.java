package com.lanou.java.Test.mondle.dao;


import com.lanou.java.Test.mondle.vo.Book;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<Book> selectAllo() throws Exception {
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = source.getConnection();
        String sql = "select * from book";
        QueryRunner runner = new QueryRunner();
        List<Book> books = runner.query(conn, sql, new BeanListHandler<>(Book.class));
        return books;
    }
}
