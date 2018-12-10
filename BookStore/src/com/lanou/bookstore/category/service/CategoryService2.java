package com.lanou.bookstore.category.service;


import com.lanou.bookstore.category.dao.findAllDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.JDBCUtil;

import java.util.List;

public class CategoryService2 {
    private findAllDao findAllDao = new findAllDao();
    public List<Category> getResult(String a) {
        try {
            JDBCUtil.begin();
            return findAllDao.find(a);
        } finally {
            JDBCUtil.closeConn();
        }
    }
}
