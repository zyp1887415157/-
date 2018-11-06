package com.lanou3g.look;

import com.google.gson.Gson;
import com.lanou3g.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AllServlet", urlPatterns = "/all")
public class AllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        ComboPooledDataSource source = new ComboPooledDataSource();
        PrintWriter writer = response.getWriter();
        try {
            Connection conn = source.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select * from t_user";
            List<UserBean> query1 = runner.query(conn, sql, new BeanListHandler<>(UserBean.class,new BasicRowProcessor(new GenerousBeanProcessor())));
            Gson gson = new Gson();
            String s = gson.toJson(query1);
            writer.println(s);
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
