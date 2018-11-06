package com.lanou3g.register_login;

import com.lanou3g.bean.HeaderImageBean;
import com.lanou3g.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

@WebServlet(name = "LoginServlet", urlPatterns = "/login.action")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上传的用户名 和密码

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ComboPooledDataSource source = new ComboPooledDataSource();
        PrintWriter out = response.getWriter();
        String msg = null;

        try {
            Connection conn = source.getConnection();
            QueryRunner runner = new QueryRunner();
            String userQuery = "select * from t_user where username = ?";
            Object[] userValues = {username};
            UserBean user = runner.query(conn, userQuery, new BeanHandler<>(UserBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), userValues);
            if (password != null && password.equals(user.getPassword())) {
                //登录成功了,  根据用户的imageId 来查询头像信息
                String imgQuery = "select * from t_header_image where image_id = ?";
                Object[] imgValues = {user.getImageId()};
                HeaderImageBean header = runner.query(conn, imgQuery, new BeanHandler<>(HeaderImageBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), imgValues);
                //把头像信息 存储到session域中
                HttpSession session = request.getSession();
                session.setAttribute("header",header);
//                out.println("用户名为:"+user.getUsername());
//                out.println("<br>");
//                out.println("头像为:");
                //显示图片,src中填写的是登陆的用户名的头像地址
//                out.println("<img src=\"own-header\"/>");
                String username1 = user.getUsername();
                request.setAttribute("username1",username1);
                request.setAttribute("img","own-header");
                msg = "登录成功";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("WEB-INF/photo1.jsp").forward(request,response);
            }else {
                msg = "<a href  = \"Login.html\">登录失败,点击返回登录</a>";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("WEB-INF/result.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
