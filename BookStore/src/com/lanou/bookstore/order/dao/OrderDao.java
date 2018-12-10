package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.user.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    //添加订单
    public void addOrder(Order order) {
        Connection conn = JDBCUtil.getConn();
        String sql = "insert into orders values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, order.getOid());
            statement.setString(2, order.getOrdertime());
            statement.setDouble(3, order.getTotal());
            statement.setInt(4, order.getState());
            statement.setString(5, order.getUid());
            statement.setString(6, order.getAddress());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    //查询所有订单
    public List<Order> findByUid(String uid) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        List<Order> orders = new ArrayList<>();
        String sql = "select * from orders where uid = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, uid);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            //调用 下面的方法
            List<OrderItem> list = findByOid(rs.getString("oid"));
            Order order = new Order();
            order.setOid(rs.getString("oid"))
                    .setOrdertime(rs.getString("ordertime"))
                    .setTotal(rs.getDouble("total"))
                    .setState(rs.getInt("state"))
                    .setUid(rs.getString("uid"))
                    .setAddress(rs.getString("address"))
                    .setOrderItemList(list);
            orders.add(order);
        }
        rs.close();
        statement.close();
        return orders;
    }


    //添加订单中的书籍
    public void addOrderItemList(List<OrderItem> orderItems) {
        Connection conn = JDBCUtil.getConn();
        try {
            for (OrderItem orderItem : orderItems) {

                String sql = "insert into orderitem values (?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, orderItem.getIid());
                statement.setInt(2, orderItem.getCount());
                statement.setDouble(3, orderItem.getSubtotal());
                statement.setString(4, orderItem.getOid());
                statement.setString(5, orderItem.getBid());
                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }
        }
    }


    //返回所有订单
    //查看订单中的所有书
    private List<OrderItem> findByOid(String oid) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        BookDao bookDao = new BookDao();
        List<OrderItem> list = new ArrayList<>();
        String sql = "select * from orderitem where oid =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, oid);
        ResultSet rs = statement.executeQuery();
        OrderItem orderItem = null;
        while (rs.next()) {
            orderItem = new OrderItem();
            orderItem.setIid(rs.getString("iid"))
                    .setCount(rs.getInt("count"))
                    .setSubtotal(rs.getFloat("subtotal"))
                    .setOid(rs.getString("oid"))
                    .setBid(rs.getString("bid"));
            Book book = bookDao.findBook(orderItem.getBid());
            orderItem.setBook(book);
            list.add(orderItem);
        }
        rs.close();
        statement.close();
        return list;
    }

    //加载订单
    public Order load(String oid) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        Order order = new Order();
        String sql = "select * from orders = where oid =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, oid);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            order.setOid(rs.getString("oid"))
                    .setState(rs.getInt("state"))
                    .setOrdertime(rs.getString("ordertime"))
                    .setUid(rs.getString("uid"));
        }
        statement.close();
        rs.close();
        return order;

    }

    //修改订单状态
    public void updateState(String oid, int state) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql = "update orders set state=? where oid = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, state);
        statement.setString(2, oid);
        statement.executeUpdate();
        statement.close();
    }
}
