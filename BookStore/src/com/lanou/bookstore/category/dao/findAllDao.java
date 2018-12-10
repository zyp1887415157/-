package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


public class findAllDao {
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from book";

        Connection conn = JDBCUtil.getConn();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                setCategoryParam(category, rs);
                categories.add(category);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categories;
    }


    public List<Category> find(String a) {
        List<Category> categories = new ArrayList<>();
        String sql = "select bid,bname,price,author,image,book.cid,cname from book,category where category.cid = book.cid and book.cid = ?";

        Connection conn = JDBCUtil.getConn();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, a);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                setCategoryParam(category, rs);
                categories.add(category);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categories;
    }


    private void setCategoryParam(Category category, ResultSet rs) throws SQLException {
        String bid = rs.getString("bid");
        String cid = rs.getString("cid");
        String bname = rs.getString("bname");
        Float price = rs.getFloat("price");
        String image = rs.getString("image");
        category.setBid(bid)
                .setBname(bname)
                .setPrice(price)
                .setImage(image)
                .setCid(cid);

    }
}
