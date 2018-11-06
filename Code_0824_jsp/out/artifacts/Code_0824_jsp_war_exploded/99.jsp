<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/24
  Time: 上午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        .red {
            color: red;
        }

        .green {
            color: green;
        }

        .blue {
            color: blue;
        }
    </style>
</head>
<body>
<table style="font-size: 20px">
    <%
        for (int i = 1; i <= 9; i++) {
    %>
    <tr>
        <%
            for (int j = 1; j <= i; j++) {
        %>
        <td>
            <span class="red"><%=j%></span>
            x
            <span class="green"><%=i%></span>
            =
            <span class="blue"><%=i * j%></span>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
