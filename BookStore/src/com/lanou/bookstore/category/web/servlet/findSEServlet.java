package com.lanou.bookstore.category.web.servlet;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryService2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findSEServlet", urlPatterns = "/findSE")
public class findSEServlet extends HttpServlet {
    private CategoryService2 categoryService2 = new CategoryService2();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService2.getResult("1");
        request.setAttribute("cg", categories);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
