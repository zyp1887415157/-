<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/28
  Time: 下午7:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=request.getAttribute("msg")%></h1>
<h1>用户名:<%=request.getAttribute("username1")%></h1>
用户头像:<img src="<%=request.getAttribute("img")%>">
</body>
</html>
