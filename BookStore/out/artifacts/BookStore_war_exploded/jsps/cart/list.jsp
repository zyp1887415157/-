<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.lanou.bookstore.cart.domain.CartItem" %>
<%@ page import="com.lanou.bookstore.cart.domain.Cart" %>
<%@ page import="com.lanou.bookstore.book.domain.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>购物车列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        * {
            font-size: 11pt;
        }

        div {
            margin: 20px;
            border: solid 2px gray;
            width: 150px;
            height: 150px;
            text-align: center;
        }

        li {
            margin: 10px;
        }

        #buy {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -902px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        #buy:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -938px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
    </style>
</head>

<body>
<h1>购物车</h1>

<table border="1" width="100%" cellspacing="0" background="black">
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <a href="<%=request.getContextPath()%>/clear?method=doPost&onclick=alert('购物车已清空')">清空购物车</a>
        </td>
    </tr>

    <tr>
        <th>图片</th>
        <th>书名</th>
        <th>作者</th>
        <th>单价</th>
        <th>数量</th>
        <th>小计</th>
        <th>操作</th>
    </tr>
    <%
        Cart cart = (Cart) application.getAttribute("cart");

        Map<String, CartItem> map = (Map<String, CartItem>) session.getAttribute("map");
        Set<String> bids = map.keySet();
        for (String bid : bids) {
            CartItem cartItem = map.get(bid);
            Book book = cartItem.getBook();
    %>

    <tr>
        <td>
            <div><img src="<c:url value='<%=request.getContextPath()+"/"+book.getImage()%>'/>"/></div>
        </td>
        <td><%=book.getBname()%>
        </td>
        <td><%=book.getAuthor()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td><%=cartItem.getCount()%>
        </td>
        <td><%=book.getPrice() * cartItem.getCount()%>
        </td>
        <td><a href="<%=request.getContextPath()%>/delete?method=doPost&bid=<%=book.getBid()%>"
               onclick="alert('删除成功')">删除</a></td>
    </tr>
    <%
        }
    %>

    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            合计<%=cart.getTotal(map)%>元
        </td>
    </tr>

</table>
<form action="/add?method=add" method="post">
    <input type="submit" value="一键购买">
</form>
</body>
</html>
