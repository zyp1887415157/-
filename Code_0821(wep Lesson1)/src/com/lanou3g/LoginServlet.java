package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    // HttpServlet 封装了Http协议

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //专门处理前端发送过来的get请求
//        设置请求编码格式
//        req.setCharacterEncoding("utf-8");
//        为了让前端浏览器可以正常显示汉字,需要告诉浏览器汉字的编码格式
//        此信息需要保存在响应头中   注意!!!  必须在获取输出流之前设置响应头

//        设置响应编码格式  告知浏览器响应数据为文本类型/html格式;编码为utf-8;
        resp.setContentType("text/html;charset=utf-8");
//        设置响应头信息
//        resp.setHeader();  一个key对应一个value
//        resp.addHeader();  一个key可以对应多个value

        resp.getWriter().println("你XXX🐩XXX");
        resp.getWriter().println("<h1>你好</h1>");
        resp.getWriter().println("<h1>你好</h1>");
        resp.getWriter().println("<h1>你好</h1>");
//        请求重定向到百度
//        resp.sendRedirect("https://www.baidu.com");

//        请求转发到百度
//        request.getRequestDispatcher("https://www.baidu.com").forward(request, response)

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.doGet(req,resp);
    }
}
