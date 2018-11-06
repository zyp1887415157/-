package com.lanou3g.result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username1");
        Object password1 = session.getAttribute("password1");
        String msg = null;
        if (username1 == null && password1 == null) {
            msg = "<a href  = \"login.html\">登录失败,点击返回登录</a>";
        } else {
            msg = "登录成功";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
