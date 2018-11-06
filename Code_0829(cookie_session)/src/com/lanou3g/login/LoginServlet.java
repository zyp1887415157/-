package com.lanou3g.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if ("admin".equals(username) && "admin".equals(password)) {
            //登陆成功  跳转到结果页面
            //在session域中 保存用户信息
            session.setAttribute("user", username);

            //2分钟免登陆需要设置?
            //答:
            // 需要把JSESSIONID 这个cookie有效时长设置为2分钟
            Cookie sessionId = new Cookie("JSESSIONID", session.getId());
            sessionId.setMaxAge(20);
            response.addCookie(sessionId);
        }else {
            session.removeAttribute("user");
        }
        //重定向到结果页面  处理登录结果
        response.sendRedirect("/loginResult");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
