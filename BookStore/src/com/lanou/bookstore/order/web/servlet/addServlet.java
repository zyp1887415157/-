package com.lanou.bookstore.order.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cart;
import com.lanou.bookstore.cart.domain.CartItem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.BaseServlet;
import com.lanou.bookstore.user.util.TestUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "addServlet", urlPatterns = "/add")
public class addServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        Double sumMoney = 0.0;
        List<OrderItem> orderItemList = new ArrayList<>();
        String orderNum = TestUUID.getRandomString();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();
        Set<String> bids = cartItemMap.keySet();
        for (String bid : bids) {
            OrderItem orderItem = new OrderItem();
            String itemNum = TestUUID.getRandomString();
            CartItem cartItem = cartItemMap.get(bid);
            Book book = cartItem.getBook();
            int count = cartItem.getCount();
            orderItem.setIid(itemNum)
                    .setCount(count)
                    .setSubtotal(count * book.getPrice())
                    .setOid(orderNum)
                    .setBid(book.getBid())
                    .setBook(book);
            orderItemList.add(orderItem);
            sumMoney = sumMoney + book.getPrice() * count;
        }
        User user = (User) request.getSession().getAttribute("user");
//        String sumMoney1 = request.getParameter("sumMoney");
//        Double sumMoney = Double.valueOf(sumMoney1);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm");
        order.setOid(orderNum)
                .setOrdertime(simpleDateFormat.format(date))
                .setTotal(sumMoney)
                .setState(1)
                .setUid(user.getUid())
                //地址先不写
                .setAddress("")
                .setOrderItemList(orderItemList);
        orderService.add(order);
        request.setAttribute("order", order);
        cartItemMap.clear();
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request, response);
    }

    private void orders(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/jsps/user/login.jsp");
            return;
        }
        List<Order> orders = orderService.findByUid(user.getUid());
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/jsps/order/list.jsp")
                .forward(request, response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String oid = request.getParameter("oid");
        //点击付款,按oid查询该订单
        Order order = orderService.load(oid);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/jsps/order/desc.jsp")
                .forward(request, response);
    }

    private void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String oid = request.getParameter("oid");
        String msg = orderService.confirm(oid);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/jsps/order/msg.jsp")
                .forward(request, response);
    }
}

