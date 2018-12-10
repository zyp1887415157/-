package com.lanou.bookstore.user.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * If there are no bugs, it was created by Chen FengYao on 2018/5/28;
 * Otherwise, I don't know who created it either
 */

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 所有!!!!!
        // 继承这个BaseServlet的Servlet
        // 参数中必须携带method这个参数
        // 无论 get还是post
        // method 就是 前端 告诉 后端 调用他的 哪个方法
        String method = req.getParameter("method");
        // 开启反射
        Class clazz = this.getClass();

        // 找方法
        try {
            Method m = clazz.getDeclaredMethod(method,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            // 让这个方法能够被调用
            m.setAccessible(true);
            m.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            String errorMsg = "前端的method参数为:" + method
                    + "但是在你的" + clazz.getSimpleName()
                    + "中 找不到 方法名为: " + method
                    + " 的方法,你写错了";
            throw new RuntimeException(errorMsg);
        } catch (NullPointerException e){
            String errorMsg = "前端没有传递method参数";
            throw new RuntimeException(errorMsg);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}