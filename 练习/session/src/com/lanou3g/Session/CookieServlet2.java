package com.lanou3g.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet2",urlPatterns = "/a/b/c/cookie.do")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie =new Cookie("cookie02","hello");
        cookie.setPath("/a/b/c");
        response.addCookie(cookie);
        PrintWriter writer = response.getWriter();
        for (Cookie c : request.getCookies()) {
            String name = c.getName();
            String value = c.getValue();
            writer.println(name+"::"+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
