package com.lanou3g;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownLoadServlet", urlPatterns = "/down")
public class DownLoadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //4.响应头如果需要显示中文,需要把中文进行URL编码
        String s = URLEncoder.encode("HTTP协议", "utf-8");
        //告诉浏览器发送的数据是什么格式的   MIME格式
        response.setContentType("image/png;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + s + ".jpg");
        InputStream is = getServletContext().getResourceAsStream("pic/vv.png");
//        response.getOutputStream().write(IOUtils.toByteArray(is));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line = is.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
        }
        outputStream.close();
        is.close();
    }
}
