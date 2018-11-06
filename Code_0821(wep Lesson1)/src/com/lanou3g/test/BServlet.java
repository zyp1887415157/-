package com.lanou3g.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BServlet", urlPatterns = "/b")
public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       先设置编码格式(两种方法)
        response.setContentType("text/html;charset=utf-8");
//        response.addHeader("content-Type", "text/html;charset=utf-8");
        response.addHeader("Refresh","5;URL=/index.jsp");
        response.getWriter().println("<a href=\"/index.jsp\">"+"5s后回到主页如果没成功点击此处</a>");
    }
}
