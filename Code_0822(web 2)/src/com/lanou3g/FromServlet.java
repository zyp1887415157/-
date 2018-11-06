package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FromServlet",urlPatterns = "/from")
public class FromServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        //POST请求设置编码格式
        //这个设置只对POST请求生效
        request.setCharacterEncoding("utf-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在Servlet中如何接收前端传递过来的数据
        //get请求接收前端发送过来的数据
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
//        byte[] bytes = username.getBytes("iso-8859-1");
//        username = new String(bytes,"utf-8");
        response.getWriter().println(username);

    }
}
