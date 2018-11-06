package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 第一次获取session对象的时候 如果参数写成false,那么不会创建
        //默认值为  true;
        HttpSession session = request.getSession();
        //获取session的id
        //每个用户的session id都是不同的
        String id = session.getId();
        //默认session在服务器内存中保存30分钟
        //在用户每次访问服务器的时候,这个时间都会刷新 (session存活时间)
//        session.setMaxInactiveInterval(10);
        session.setAttribute("times",1);
        //使session 失效  退出登录时可以使用
//        session.invalidate();
        //重定向到DisplayServlet
        response.sendRedirect("/display");

        //出现的问题  直接访问display的时候
        //与预期的情况不一样,显示出了null
        //页面显示出null  说明系统正确获取到了session
        //并且session中没有保存times这条数据
        //原因:启动Tomcat之后,会直接打开index页面
        //在这个页面中,虽然没有写req.getSession
        //但是,系统也会自动创建一个session
        //所以第一次访问display页面也会获取到session,导致false这个参数运行情况与预期不一样
        //解决方法:在启动配置中,取消勾选 OPen Browser
        //这样一来,tomcat启动后,就不会自动打开首页
    }
}
