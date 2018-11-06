package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayServlet", urlPatterns = "/display")
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示 用户访问该页面的次数
        HttpSession session = request.getSession(false);
        if (session == null){
            response.sendRedirect("/session");
            return;
        }
        //获取session域中保存的数据
        // 原来的次数
        Integer times = (Integer) session.getAttribute("times");
        PrintWriter writer = response.getWriter();
        writer.println(times);
        writer.println(session.getId());


        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //取 key
            String name = cookie.getName();
            //取  value
            String value = cookie.getValue();
//            PrintWriter writer = response.getWriter();
            writer.println(name + "--" + value);
        }

        //访问次数 +1 覆盖掉session中  原来的次数
        session.setAttribute("times",times+1);
        writer.close();
    }
}
