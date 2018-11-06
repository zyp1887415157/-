package com.lanou3g;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {

    /*
    每个Servlet的对象,都只有一个
    但是,Servlet的对象的方法 可以执行在不同的线程中
    在Servlet类中, 成员变量的声明需要小心.
    成员变量只能赋值一次,
    尽量不声明引用数据类型,
    如果需要声明引用的数据类型,那么这个类最好不要有属性
    如果非要有属性,属性最好是final的,
    ---------
    最好用ThreadLocal对成员变量进行处理.
     */

    private ServletConfig config;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化
        // 该方法只会执行一次
        // 在该Servlet创建的时候会执行一次
        // 一般执行一些初始化的工作.
        this.config = servletConfig;

//        System.out.println("init 被调用");
        System.out.println("HelloServlet.init");

        //像这种的,  某些方法不是由开发者自己调用的
        //并且规定了某个对象的出生到死亡的过程,
        //这样的方法叫做,生命周期方法.
    }


    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        //获取输出流
        PrintWriter writer = resp.getWriter();
        writer.println("<a href=\"https://www.baidu.com/\" style=\"background-color: fuchsia\">HelloServlet</a>");
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        //在该Servlet对象销毁的时候 会执行该方法
        // 当Tomcat 退出的时候  Servlet对象会销毁
        // 可以做一些 资源释放的操作
        System.out.println("HelloServlet.destroy");
    }
}
