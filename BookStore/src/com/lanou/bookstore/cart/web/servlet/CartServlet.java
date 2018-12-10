package com.lanou.bookstore.cart.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cart;
import com.lanou.bookstore.cart.domain.CartItem;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bid = request.getParameter("bid");

        int count = Integer.parseInt(request.getParameter("count"));

        Book book = new BookDao().findBook(bid);
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setCount(count);

        Cart cart = (Cart) request.getSession().getAttribute("cart");


        Map<String,CartItem>map = cart.add(cartItem);
        HttpSession session = request.getSession();
        ServletContext app = session.getServletContext();
        app.setAttribute("cart",cart);
        request.getSession().setAttribute("map",map);
        response.sendRedirect(request.getContextPath()+"/jsps/cart/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
