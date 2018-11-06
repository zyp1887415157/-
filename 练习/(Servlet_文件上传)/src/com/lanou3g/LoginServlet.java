package com.lanou3g;

import com.lanou3g.bean.HeaderImageBean;
import com.lanou3g.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String code = request.getParameter("code");
        ComboPooledDataSource source = new ComboPooledDataSource();
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try {
            Connection conn = source.getConnection();
            QueryRunner runner = new QueryRunner();
            HttpSession session1 = request.getSession();
            String validateCode = (String) session1.getAttribute("validateCode");
            String userQuery = "select * from t_user where username = ?";
            UserBean query = runner.query(conn, userQuery, new BeanHandler<>(UserBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), username);
            if (code == null) {
                writer.println("<h4>验证码不能为空</h4>");
                return;
            } else if
                    (!validateCode.equals(code)) {
                writer.println("<h4>验证码输入错误</h4>");
                return;
            } else if (password != null && query != null && validateCode.equals(code) && password.equals(query.getPassword())) {
                String imgValues = "select * from t_header_image where image_id = ?";
                HeaderImageBean header = runner.query(conn, imgValues, new BeanHandler<>(HeaderImageBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), query.getImageId());
                session.setAttribute("header", header);
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(50);
                response.addCookie(cookie);
                String username1 = query.getUsername();
                String password1 = query.getPassword();
//                session.setAttribute("user",query);
                session.setAttribute("password1", password1);
                session.setAttribute("username1", username1);
                session.setAttribute("img", "showImg");
//                msg = "登录成功";
//                request.setAttribute("msg", msg);
//                request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);
            } else {
                session.removeAttribute("username1");
//                msg = "<a href  = \"login.html\">登录失败,点击返回登录</a>";
//                request.setAttribute("msg", msg);
//                response.sendRedirect("/result");
//                request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);
            }
            response.sendRedirect("/result");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
