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
import java.sql.PreparedStatement;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String gender = request.getParameter("gender");
            PrintWriter writer = response.getWriter();
            if (password1.equals(password2)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                ComboPooledDataSource source = new ComboPooledDataSource();
                Connection connection = source.getConnection();
//                String url = "jdbc:mysql://localhost:3306/lan_ou";
//                String user = "root";
//                String password = "123456";
//                Connection conn = DriverManager.getConnection(url, user, password);
                String sql = "insert into users (username,password,gender) values(?,?,?)";
//                PreparedStatement statement = conn.prepareStatement(sql);
//                statement.setString(1, username);
//                statement.setString(2, password1);
//                statement.setString(3, gender);
//                statement.executeUpdate();
//                statement.close();
//                conn.close();
//                PreparedStatement statement = connection.prepareStatement(sql);
                QueryRunner runner = new QueryRunner();
                Object[] o = {username, password1, gender};
                runner.insert(connection, sql, new BeanListHandler<>(User.class, new UnderlineProcessor()),o);
                writer.println("<h1>注册成功</h1>");
                return;
            }
            writer.println("<h1>注册失败</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
