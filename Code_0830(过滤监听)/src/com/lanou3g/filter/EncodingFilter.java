package com.lanou3g.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//对所有进行过滤
@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
public class EncodingFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        //设置请求体中文本的编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应体中文本的编码格式
        resp.setCharacterEncoding("utf-8");
        //设置响应头
        resp.setContentType("text/html;charset=utf-8");
        //执行这条  说明到servlet中的doGet/doPost
        Chain.doFilter(req,resp);
    }
}
