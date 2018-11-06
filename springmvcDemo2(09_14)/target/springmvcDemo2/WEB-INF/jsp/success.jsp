<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/14
  Time: 上午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>success</h2>
<h2>${user}</h2>
<form action="/user/page.action">
    第<input type="text" name="pagenum">页
    <input type="submit" value="go">
</form>
</body>
</html>
