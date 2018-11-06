package com.lanou3g.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "CookieServlet3",urlPatterns = "/cookie03")
public class CookieServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //Cookie 可以设置存活时间
        //URL编码  解决了cookie不能储存中文的问题
        String val = URLEncoder.encode("哈哈","utf-8");
        Cookie cookie = new Cookie("cookie03",val);
        //存活时间单位是秒
        /*
        maxAge:>0 表示cookie存活多少秒,到时间浏览器自动删除该 cookie
        maxAge:<0 表示无论设置成多少都表示活到浏览器关闭,默认值 是-1
        maxAge:=0 表示告诉浏览器立即删除这个cookie
         */
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        //让cookie可以再各个二级域名之间共享
        //cookie.setDomain("baidu.com");
        /*
        www.baidu.com
        .com 顶级域名
        baidu.com 一级域名
        www.baidu.com 二级域名
         */
        PrintWriter writer = response.getWriter();
        for (Cookie c : request.getCookies()) {
            String name = c.getName();
            String value = c.getValue();
            writer.println(name+":"+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
