package com.lanou3g;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContextServlet",urlPatterns = "/context")
public class ServletContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取ServletContext  不同方式获取的是同一个对象
        ServletContext context = getServletContext();
        ServletContext context1 = getServletConfig().getServletContext();
        ServletContext context2 = request.getServletContext();
        /*
        在开发环境/生产环境当前的工程目录肯定会发生变化的
        甚至于开发环境与生产环境的操作系统是不一样的
        所以说在使用某个路径的时候,一定要充分考虑所有不同的情况
        该方法,可以在不同的环境下动态的获取当前工程所在的目录
         */
        String path = context.getRealPath("pic/A.jpg");
        response.getWriter().println(path);

    }
}
