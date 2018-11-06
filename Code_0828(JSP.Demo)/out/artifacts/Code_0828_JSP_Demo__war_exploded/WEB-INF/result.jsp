<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/28
  Time: 下午3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
<%
    //内置对象
    /*
    request
    response
    ServletContext  application(最大域对象)
    session
    out
    page  == this
    pageContext  保存当前页面
    exception    保存一些异常
    config
     */

    //项目路径(IP地址后面的)
    String contextPath = request.getContextPath();
    //
    String servletPath = request.getServletPath();

//    out.println("context"+contextPath);
//    out.println("<br>");
//    out.println("servlet"+servletPath);
%>
<h1>
    <%--<%=request.getAttribute("msg")%>--%>
    ${msg}
</h1>
</body>
</html>
