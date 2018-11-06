package com.lanou3g.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取前端发送过来的验证码
        String code = request.getParameter("code");
        // 获取Session 中 保存的验证码
        HttpSession session = request.getSession();
        String validateCode = (String) session.getAttribute("validateCode");
        if (validateCode != null && validateCode.equalsIgnoreCase(code)) {
            response.getWriter().println("<h1>验证成功</h1>");
        }else {
            response.getWriter().println("<h1>验证失败</h1>");
        }
    }
}
