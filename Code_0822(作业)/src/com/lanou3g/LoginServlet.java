package com.lanou3g;

import com.lanou3g.Test.UnderlineProcessor;
import com.lanou3g.Test.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ComboPooledDataSource source = new ComboPooledDataSource();
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        String code = request.getParameter("code");
        PrintWriter writer = response.getWriter();
        try {
            Connection conn = source.getConnection();
            QueryRunner runner = new QueryRunner();
            HttpSession session = request.getSession();
            String validateCode = (String) session.getAttribute("validateCode");
            String sql = "select * from users ";
            List<User> query = runner.query(conn, sql, new BeanListHandler<>(User.class, new UnderlineProcessor()));
            for (User user : query) {
                String username = user.getUsername();
                String password = user.getPassword();
                if (!validateCode.equals(code) && code != null) {
                    writer.println("<h4>验证码输入错误</h4>");
                    return;
                }
                if (username1.equals(username) && password1.equals(password) && validateCode.equals(code)) {
                    writer.println("<a href =\"Login.html\" ><h1>登录成功</h1></a>");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("<a href=\"Login.html\">登录失败,点击返回登录页面</a>");

//        response.sendRedirect("index.jsp");
    }
}
