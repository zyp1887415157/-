package com.lanou3g.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginResultServlet", urlPatterns = "/loginResult")
public class LoginResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否登陆成功
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        //如果 user 不为  null  注册成功
        String result;
        String msg;
        String path;
        if (user == null) {
            result = "登录失败";
            msg = "5秒后跳转到登录页面";
            path = "/login.jsp";
        } else {
            result = "登陆成功";
            msg = "5秒后跳转到游戏列表页面";
            //
            path = "/game-list";
        }
        request.setAttribute("result", result);
        request.setAttribute("msg", msg);
        request.setAttribute("path", path);
        //5 秒后跳转功能
        response.setHeader("Refresh", "5;url=" + path);
        //请求转发到登录结果页面
        request.getRequestDispatcher("/loginResult.jsp").forward(request, response);
    }
}
