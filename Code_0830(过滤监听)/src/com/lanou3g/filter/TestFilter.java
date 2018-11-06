package com.lanou3g.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 生命周期方法
        // 当这个过滤器对象创建的时候会执行
        // 一个过滤器只会创建一个对象
        // 这个方法只会执行一次
        System.out.println("TestFilter.init");
        String charset = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("在放行之前执行");
        //放行
        filterChain.doFilter(Request, Response);
        System.out.println("在放行之后执行");
    }

    @Override
    public void destroy() {
        //生命周期方法
        //当这个过滤器对象销毁的时候,会执行这个方法
        System.out.println("TestFilter.destroy");
    }
}
