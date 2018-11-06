package com.lanou3g;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //使用JDBC操作存储过程

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        // CallableStatement 用来调用过程的
        CallableStatement call = conn.prepareCall("{call query_stu()}");
        //执行过程
        //执行过程 一般会用executeQuery()方法
        ResultSet set = call.executeQuery();
        //结果集的处理跟普通查询一样
//        while (set.next()) {
//            String string = set.getString("name");
//        }
        //------------------分界线--------------------------
        //获取过程中的out参数的值
        CallableStatement out = conn.prepareCall("{call insert_stu(?,?,?,?)}");
        out.setString(1,"段延庆");
        out.setDate(2,Date.valueOf("1899-10-10"));
        out.setString(3,"男");
        // 注册输出参数
        //设置过程中的第几个问号的数据类型是什么
        out.registerOutParameter(4,Types.INTEGER);
        //调用过程
        out.executeQuery();
        //过程调用完毕之后,取出out参数的值
        int qty = out.getInt(4);
        System.out.println(qty);

    }
}
