package com.lanou3g.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/validate/*")
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        //比如现在有3个页面是不需要登录就可以访问的
        //  login  register  home
        //http://www.baidu.com
        //以一定的规则,来为所有的地址命名
        //比如说:直接能访问的地址  /open/login   /open/register
        // 需要登录才能访问的,  /validate/game-list
//        String uri = req.getRequestURI();
//        System.out.println(uri);

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            //如果登陆了,就放行
            Chain.doFilter(req,resp);
        }else {
            //如果没登录重定向到登录页面
            resp.sendRedirect("/index.jsp");
        }
    }
}
