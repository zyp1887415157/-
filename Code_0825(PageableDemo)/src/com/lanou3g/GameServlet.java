package com.lanou3g;

import com.google.gson.Gson;
import com.lanou3g.common.ResultWrapper;
import com.lanou3g.controller.GameController;
import com.lanou3g.controller.GameControllerImpl;
import com.lanou3g.controller.TestGameController;
import com.lanou3g.dao.GameDao;
import com.lanou3g.dao.GameDaoImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GameServlet", urlPatterns = "/game.json")
public class GameServlet extends HttpServlet {
    //后台接收到前端发送过来的分页参数之后需要做什么?
    /*
    1.接收前端传递过来的数据  String  类型
    2.如果没有值则给page和count默认值
    3.把 String 类型 转换为  int 类型
    4.根据page  和  count  计算出 对应的limit两个值((page-1)*count)
    5.查询数据库数据的总数
    6.查询数据库  分页的数据
    7.整合数据,转成JSon, 返回给前端
     */
    private GameController gameController;

    @Override
    public void init() throws ServletException {
        gameController = new GameControllerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        int page, count;
        try {
            page = Integer.parseInt(request.getParameter("page"));

        } catch (Exception e) {
            page = 1;
        }
        try {
            count = Integer.parseInt(request.getParameter("count"));
        } catch (Exception e) {
            count = 20;
        }

        ResultWrapper result = gameController.findGame(page, count);
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String s = gson.toJson(result);
        writer.write(s);
        writer.close();

    }
}

