package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ImageServlet", urlPatterns = "/image/timg.jpg")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        String referer = request.getHeader("Referer");
        String image;
        if (referer == null || !referer.contains("localhost")) {
            image = "WEB-INF/pic/error.jpg";
        }else {
            image = "WEB-INF/pic/timg.jpg";
        }
//        response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
        String realPath = request.getServletContext().getRealPath(image);
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
        }
        outputStream.close();
        fis.close();
    }
}
