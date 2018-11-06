package com.lanou3g;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends GenericServlet {

//     需要的时候可以重写出来
//    @Override
//    public void init() throws ServletException {
//
//    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("HomeServlet");
        writer.close();
    }
}
