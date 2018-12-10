package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.domain.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    BookDao bookDao = new BookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid =  request.getParameter("bid");
        //List<Book> books =bookDao.findBook(bid);
        Book books = bookDao.findBook(bid);
        request.setAttribute("cg", books);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
