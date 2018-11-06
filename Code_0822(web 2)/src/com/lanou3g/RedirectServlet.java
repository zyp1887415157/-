package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet",urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        发送重定向
//        response.sendRedirect("https://www.baidu.com");
//        发送转发
//        request.getRequestDispatcher("register.html").forward(request,response);
        //设置响应码   2XX  都表示成功
        // 4XX   表示客户端问题
        // 5XX   表示服务端问题
//        response.setStatus(302);
//        response.setHeader("Location","register.html");
        // 隔几秒种 跳转到某个页面
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("refresh","5;url=https://www.baidu.com");
        response.getWriter().println("<a  href=\"https://www.baidu.com\">5秒之后自动跳转</a>");
    }
}
