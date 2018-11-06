package com.lanou3g.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {
        doFilter((HttpServletRequest)Request,(HttpServletResponse) Response,Chain);
    }

    public abstract void doFilter(HttpServletRequest Request, HttpServletResponse Response, FilterChain Chain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
