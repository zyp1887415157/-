package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.dao.findAllDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private findAllDao findAllDao = new findAllDao();
    public List<Category> getResult(String cid) {
        try {
            JDBCUtil.begin();
            return findAllDao.findAll();
        } finally {
            JDBCUtil.closeConn();
        }
    }
}
