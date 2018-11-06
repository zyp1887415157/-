package com.lanou3g.filter;

//为了方便使用,自己创建一个创建一个过滤器的基类

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方便:
 * 1.init和destroy两个方法可以根据需要来写
 * 2.doFilter的参数让他支持Http协议
 */
public abstract class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest) Request, (HttpServletResponse) Response, filterChain);
    }

    public abstract void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain Chain) throws IOException, ServletException;


    @Override
    public void destroy() {

    }
}
