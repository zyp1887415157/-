package com.lanou.bookstore.user.dao;



import com.lanou.bookstore.user.domain.User;

import com.lanou.bookstore.user.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    public List<User> getUsers(String username) {
        List<User> users = new ArrayList<>();
        String sql="SELECT * FROM tb_user WHERE username like ?";
        Connection conn=JDBCUtil.getConn();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"%"+username+"%");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                User user=new User();
                //设置每一个用户的属性
                setUserParam(user,rs);
                //把这个用户加入到集合中
                users.add(user);
            }
                rs.close();
                statement.close();



        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public User login(String username, String password) {

        if (username == null || password == null) {
            return null;
        }
        try {
            User user = new User();
            Connection conn = JDBCUtil.getConn();
            String sql = "select * from tb_user where username=? and password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            setUserParam(user, rs);

            rs.close();
            statement.close();

            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void setUserParam(User user, ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("password");
        String uid = rs.getString("uid");
        //设置User属性
        user.setUsername(username)
                .setPassword("")
                .setUid(uid);
    }


    //能否登录成功
    public boolean canLogin(String username, String pwd) {
        Connection conn = JDBCUtil.getConn();
        //执行后获得一行一列的结果
        String sql = "select count(*) from tb_user where username = ? and password=?";


        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);// 给第一个问号放值
            statement.setString(2, pwd);//给第二个问号放值
            ResultSet rs = statement.executeQuery();
            boolean canLogin = false;
            if (rs.next()) {
                int count = rs.getInt(1);//拿第一列的值
                canLogin = count > 0;//当count>0的时候说明数据库中有该用户 可以登录
            }
            statement.close();
            rs.close();


            return canLogin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
