package com.lanou3g.result;

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

@WebServlet(name = "ImgServlet",urlPatterns = "/showImg")
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HeaderImageBean header = (HeaderImageBean) session.getAttribute("header");
        ServletOutputStream out = response.getOutputStream();
        response.setContentType(header.getImageType());
        String imagePath = header.getImagePath();
        byte[] bytes = FileUtils.readFileToByteArray(new File(imagePath));
        IOUtils.write(bytes,out);
        out.close();
    }
}
