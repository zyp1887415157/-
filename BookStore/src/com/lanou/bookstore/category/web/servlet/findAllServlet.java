package com.lanou.bookstore.category.web.servlet;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findAllServlet", urlPatterns = "/findAll")
public class findAllServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid =request.getParameter("cid");
        List<Category> categories = categoryService.getResult(cid);
        request.setAttribute("cg", categories);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
