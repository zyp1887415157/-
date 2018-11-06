package com.lanou3g.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GameListServlet", urlPatterns = "/game-list")
public class GameListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //标识当前的用户是否登录了
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        boolean isLogin = user != null;
        if (isLogin) {
            //如果登陆了访问受限页面
            request.getRequestDispatcher("/game-list.jsp").forward(request, response);
        } else {
            //如果没登录,重定向到登录页面
            response.sendRedirect("/login.jsp");
        }
    }
}
