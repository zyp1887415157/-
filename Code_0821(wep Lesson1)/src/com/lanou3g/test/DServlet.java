package com.lanou3g.test;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DServlet",urlPatterns = "/d")
public class DServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=zz.mp3");
        InputStream is = getServletContext().getResourceAsStream("files/zz.mp3");
        response.getOutputStream().write(IOUtils.toByteArray(is));

    }
}
