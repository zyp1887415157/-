<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/29
  Time: 下午5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>处理结果</title>
    <script src="js/jquery-3.2.1.js"></script>
</head>
<body>
<h1>${result}</h1>
<p id="p">5</p>
<a href="${path}">${msg}</a>
<script>
    var p = document.getElementsByTagName("p")[0];
    var i = 1;
    var interval = setInterval(function () {
        if (i === 5) {
            clearInterval(interval)
        }
        p.innerText = 5 - i;
        i++;
    }, 1000)

</script>
</body>
</html>
