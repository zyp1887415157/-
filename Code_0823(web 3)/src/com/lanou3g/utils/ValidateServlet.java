package com.lanou3g.utils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//用来生成验证码图片的Servlet
@WebServlet(name = "ValidateServlet",urlPatterns = "/code")
public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        ValidateCode code = new ValidateCode(160, 40, 4, 150);
        //获取字符
        String c = code.getCode();
        //true 代表如果没有SessionID就创建一个
        HttpSession session = request.getSession(true);
        session.setAttribute("validateCode",c);
        ServletOutputStream out = response.getOutputStream();
        code.write(out);
        out.close();
    }
}
