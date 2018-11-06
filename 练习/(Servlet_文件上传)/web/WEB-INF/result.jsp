<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/29
  Time: 上午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.2.1(1).js"></script>
    <%--<script src="../js/jquery-2.2.4.min.js"></script>--%>
    <style>
        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1><%=request.getAttribute("msg")%>
</h1>
<%
    if ("注册成功".equals(request.getAttribute("msg"))) {
%>
<h1 style="font-size:24px;">5-秒之后自动跳转到登录页面
    <meta http-equiv="refresh" content="5;URL=login.html">
</h1>
<%
    }
%>
<%
    if ("登录成功".equals(request.getAttribute("msg"))) {
%>
<div>
    <%--<h1><%=request.getAttribute("msg")%></h1>--%>
    <h1>用户名:<%=session.getAttribute("username1")%>
    </h1>
    用户头像:<img src="<%=session.getAttribute("img")%>">
</div>
<div>
    <button id="btn1">点击查看个人信息</button>
    <button id="btn2">点击查看所有信息</button>
    <a href="/out"><button>退出登录</button></a>
</div>
<div class="right">
    <table class="table" style="border: 2px solid blue;width: 60%;position: absolute">
        <thead>
        <tr>
            <th>ID</th>
            <th>图片ID</th>
            <th>姓名</th>
            <th>密码</th>
        </tr>
        </thead>
        <tbody id="tb">

        </tbody>
    </table>
</div>
<script>
    $(function () {
        $('#btn1').click(function () {
            let url = "http://localhost:8080/one";
            $.get(url, requestFinished)
        });
        $('#btn2').click(function () {
            let url = "http://localhost:8080/all";
            $.get(url, requestFinished)
        });
        $('#btn3').click(function () {

        });

        function requestFinished(resp) {
            var body = $('#tb');
            body.empty();
            for (var item of resp) {
                var tr = $('<tr></tr>');
                var id = $('<td></td>').text(item.userId);
                var imageId = $('<td></td>').text(item.imageId);
                var username = $('<td></td>').text(item.username);
                var password = $('<td></td>').text(item.password);
                tr.append(id).append(imageId).append(username).append(password);
                body.append(tr);
            }
        }
    })
</script>
<%
    }
%>
</body>
</html>
