package com.lanou.bookstore.order.service;

import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.user.util.JDBCUtil;


import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void add(Order order) {
        try {
            JDBCUtil.begin();
            orderDao.addOrder(order);
            orderDao.addOrderItemList(order.getOrderItemList());
        } finally {
            JDBCUtil.closeConn();
        }
    }

    public List<Order> findByUid(String uid) throws Exception {
        try {
            JDBCUtil.begin();
            List<Order> orders = orderDao.findByUid(uid);
            return orders;
        } finally {
            JDBCUtil.closeConn();
        }
    }

    public Order load(String oid) throws SQLException {
        try {
            JDBCUtil.begin();
            Order order = orderDao.load(oid);
            return order;
        } finally {
            JDBCUtil.closeConn();
        }
    }
    public String confirm(String oid) throws SQLException {
        try {
            JDBCUtil.begin();
            Order order = orderDao.load(oid);
            // 这里的 3 是什么意思,我存的都是1
            if (order.getState() == 3) {
                orderDao.updateState(oid,2);
                return "确认成功,交易完成";
            } else {
                return "订单确认失败,你不是好人!";
            }

        } finally {
            JDBCUtil.closeConn();
        }
    }
}
