<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/14
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/jquery-3.3.1.min.js"></script>
</head>
<body>
<table bo style="text-align: center" border="2px">
    <tr>
        <td>username</td>
        <td>password</td>
        <td>operation</td>
    </tr>
    <form action="">
        <c:forEach items="${all}" var="all">
            <tr>
                <td><input id="a" type="text" value=${all.username}></td>
                <td><input id="b" type="text" value=${all.password}></td>
                <td><input id="input1" type="button" value="modify"><input id="input2" type="button" value="delete">
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
<br><br>
<a href="home.action">home</a>
<script>
    $(function () {
        $('#input1').click(function () {
            var a = $('#a').val();
            $('#input1').innerText = a;
        })


        $('#input2').click(function () {
            this.parentElement.parentElement.remove();
        })
    })
</script>
</body>
</html>
