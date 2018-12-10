package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.RegisterService;
import com.lanou.bookstore.user.util.TestUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private RegisterService Service = new RegisterService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username)
                .setPassword(password)
                .setUUID(TestUUID.getRandomString());
        if (password==null||username==null){
            return;
        }
        if (Service.register(user)) {
            fieldMsg(request, response, "注册成功");
        } else {
            fieldMsg(request, response, "注册失败");
        }
    }

    private void fieldMsg(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        // String msg = "用户名/密码错误,点击返回登录页面";
        request.setAttribute("msg", msg);
//        String path = "/register.jsp";
//        request.setAttribute("path", path);
        response.setStatus(302);
//        response.setHeader("refresh", "5;url=/register.jsp");
        request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
