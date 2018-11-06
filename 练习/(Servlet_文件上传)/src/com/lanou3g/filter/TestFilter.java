package com.lanou3g.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "TestFilter",urlPatterns = "")
public class TestFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain Chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username1 = (String) session.getAttribute("username1");
        if (username1 == null){
            response.sendRedirect("login.html");
            return;
        }
        Chain.doFilter(request,response);
    }
}
