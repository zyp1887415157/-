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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ComboPooledDataSource source = new ComboPooledDataSource();
        PrintWriter writer = response.getWriter();

        try {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String gender = request.getParameter("gender");
            if (password1.equals(password2)) {
                Connection conn = source.getConnection();
                QueryRunner runner = new QueryRunner();
                String sql1 = "select username from users";
                List<User> query = runner.query(conn, sql1, new BeanListHandler<>(User.class, new UnderlineProcessor()));
                int i;
                hhh:
                for (i = 0; i < query.size(); i++) {
                    for (User user : query) {
                        if (username.equals(user.getUsername())) {
                            break hhh;
                        }
                    }
                }
                if (i < query.size()) {
                    writer.println("<a href =\"Register.html\" ><h1>用户名已存在</h1></a>");
                } else if (i == query.size()) {
                    String sql = "insert into users (username,password,gender) values(?,?,?)";
                    Object[] o = {username, password1, gender};
                    runner.insert(conn, sql, new BeanListHandler<>(User.class, new UnderlineProcessor()), o);
                    response.setHeader("refresh", "5;url=index.jsp");
                    response.getWriter().println("<a  href=\"Login.html\">5秒之后自动跳转到登录页面</a>");
                    writer.println("<h1>注册成功</h1>");
                }
            } else {
                writer.println("<h1>注册失败</h1>");
                response.setHeader("refresh", "5;url=Register.html");
                response.getWriter().println("<a  href=\"Register.html\">5秒之后自动跳转到登录页面</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
