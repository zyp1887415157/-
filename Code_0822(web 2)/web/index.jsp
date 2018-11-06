<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/22
  Time: 上午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>GET请求发送数据</h1>
  <form action="from" method="get">
    用户名:<input type="text" name="username"><br>
    <input type="submit" value="提交">
  </form>
  <h1>POST请求发送数据</h1>
  <form action="from" method="post">
    用户名:<input type="text" name="username"><br>
    <input type="submit" value="提交">
  </form>
  <a href="register.html">注册</a>
  <a href="redirect">查询</a>
  </body>
</html>
