package com.lanou3g;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");


        //获取请求头
        //User-Agent 保存的是这一次请求所使用的浏览器信息
        String header = request.getHeader("User-Agent");
        response.getWriter().println("Hello" + header);

        //Referer 表示当前的Servlet是从哪个地址访问过来的

        //获取用户的IP地址  进行操作
        String addr = request.getRemoteAddr();
        if (addr.endsWith("5")) {
            response.sendError(405);
            return;
        }
        response.getWriter().println(addr + "<br>");

        //获取查询参数,  也是url中?后面的字符串
        String queryString = request.getQueryString();

        // 域对象之一  Session  Request
        //作为域对象的作用: 能存值,  能取值
        ServletContext context = request.getServletContext();
        Integer ctxCount = (Integer) context.getAttribute("ctx-count");
        if (ctxCount == null) {
            ctxCount = 1;
        } else {
            ctxCount++;
        }

        context.setAttribute("ctx-count",ctxCount);
        //所有客户端访问当前Servlet的次数
        response.getWriter().println("<h1>"+ctxCount+"</h1>");


        //ServletContext  全局的,  所有的Servlet中的数据是共享的
        //Session  会话,  一个客户端多次产生的请求, 是一个会话
        HttpSession session = request.getSession();
        Integer sessCount = (Integer) session.getAttribute("sess-count");
        if (sessCount == null) {
            sessCount = 1;
        } else {
            sessCount++;
        }

        session.setAttribute("sess-count",sessCount);
        //所有客户端访问当前Servlet的次数
        response.getWriter().println("<h1>"+sessCount+"</h1>");


        // 浏览器是客户端  后台是服务端
        //Request
//        request.setAttribute();
//        request.getAttribute();

        //请求转发




    }
}
