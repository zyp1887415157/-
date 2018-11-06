package com.lanou3g;

import com.google.gson.Gson;
import com.lanou3g.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AjaxServlet", urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        Map map = new Gson().fromJson(br,Map.class);
        System.out.println(map.get("username"));
        System.out.println(map.get("age"));

        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String age  = request.getParameter("age");
        System.out.println(username);
        System.out.println(age);
        ComboPooledDataSource source = new ComboPooledDataSource();
        try {
            Connection conn = source.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select * from users";
            List<User> query = runner.query(conn, sql, new BeanListHandler<>(User.class));
            Gson gson = new Gson();
            String s = gson.toJson(query);
            out.write(s);
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        List<Map<String, Object>> data = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            Map<String, Object> map = new HashMap();
//            map.put("id", 1 + i);
//            map.put("name", "张三" + i);
//            map.put("age", 18);
//            data.add(map);
//        }
//        String s = new Gson().toJson(data);
//        out.write(s);
//        out.close();
    }
}
