package com.lanou3g.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MySessionListener implements
        //  监听得是session的创建和销毁
        HttpSessionListener,
        // 监听ServletContext的创建和销毁
        ServletContextListener,
        // 监听Request的创建和销毁
        ServletRequestListener {
    private ServletContext app;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //每次有session创建,这个方法都会执行一次
        //获取创建的session
        HttpSession session = httpSessionEvent.getSession();
        Integer count = (Integer) app.getAttribute("user-count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        app.setAttribute("user-count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //每次有session销毁,这个方法都会执行一次

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        app = servletContextEvent.getServletContext();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }
}
