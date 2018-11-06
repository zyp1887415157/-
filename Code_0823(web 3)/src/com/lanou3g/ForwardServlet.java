package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//请求转发
@WebServlet(name = "ForwardServlet",urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发  () 里可以填JSP
        request.getRequestDispatcher("home").forward(request,response);

        //请求转发url地址不变,可以隐藏真正处理这个请求的Servlet
        //一般用来隐藏真正的页面地址

        /*
        转发与重定向的区别:
        1.请求转发客户端浏览器的URl不变,但是重定向是变化的
        2.请求转发 只能转到自己的服务器上  重定向 可以是任意网站
        3.请求转发浏览器只发起一次请求 但是重定向是两次
        4.请求转发是服务器的行为,重定向是客户端的行为
        5.请求转发,在转发到的Servlet中任然可以获取请求中(请求头,请求体都可以)的数据
        但是,重定向做不到  重定向相当于又发一次新的请求  请求信息不一样
         */
    }
}
