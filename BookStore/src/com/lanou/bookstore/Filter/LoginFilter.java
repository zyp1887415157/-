package com.lanou.bookstore.Filter;

import com.lanou.bookstore.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/jsps/cart/*",servletNames = "CartServlet", dispatcherTypes = {DispatcherType.FORWARD,
        DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user!=null){
            chain.doFilter(servletRequest,servletResponse);
        }else {
            resp.sendRedirect("/jsps/user/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
