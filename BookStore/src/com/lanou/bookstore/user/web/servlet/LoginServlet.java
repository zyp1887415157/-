package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.cart.domain.Cart;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.LoginService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = loginService.login(username,password);
        if (user==null){
            fieldMsg(request,response,"用户名/密码错误,点击返回登录页面");
        }else {
            Cart cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getSession().setAttribute("cart",cart);
            response.sendRedirect("/index.jsp");
        }


    }
    private void fieldMsg(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("msg", msg);
        response.setStatus(302);
        request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
    }
}
