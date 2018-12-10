package com.lanou.bookstore.user.dao;


import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RegisterDao {
    public boolean register(User user) {
        Connection conn = JDBCUtil.getConn();

        try {
            //开启事务
            //conn.setAutoCommit(false);
            String sqlInsert = "INSERT INTO tb_user (uid,username,password) VALUES (?,?,?)";

            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
            //psInsert.setCharacterStream(1,user.getUid());
            psInsert.setString(1, user.getUUID());
            psInsert.setString(2, user.getUsername());//user.getUsername()获取输入的用户名 并把?设置成获取的值
            psInsert.setString(3, user.getPassword());

            //执行
            psInsert.executeUpdate();//增删改 都用这个
            //psInsert.executeQuery();//查  用这个

            //查询刚刚插入的主键
            String getIDSql = "SELECT MAX(uid) FROM tb_user ";
            PreparedStatement psID = conn.prepareStatement(getIDSql);
            ResultSet rs = psID.executeQuery();
            rs.next();


            return true;//注册成功
        } catch (Exception e) {
            try {
                //如果哪条sql抛异常 我们可以回滚到sql执行之前
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }


    public boolean hasThisName(String username) {
        String sql = "select count(*) from tb_user where username = ?";

        Connection conn = JDBCUtil.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


}
