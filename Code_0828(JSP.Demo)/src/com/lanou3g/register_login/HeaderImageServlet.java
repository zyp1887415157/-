package com.lanou3g.register_login;

import com.lanou3g.bean.HeaderImageBean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "HeaderImageServlet",urlPatterns = "/own-header")
public class HeaderImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取到登录的这个人的头像信息
        HttpSession session = request.getSession();
        HeaderImageBean header = (HeaderImageBean) session.getAttribute("header");
        ServletOutputStream out = response.getOutputStream();
        //设置响应头
        response.setContentType(header.getImageType());
        //获取图片路径
        String path = header.getImagePath();
        //把文件内容写到字节输出流中
        byte[] bytes = FileUtils.readFileToByteArray(new File(path));
        IOUtils.write(bytes,out);
        out.close();
    }
}
