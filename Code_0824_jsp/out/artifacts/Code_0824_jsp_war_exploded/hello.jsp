<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/24
  Time: 上午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<%@page import="java.util.List" %> 导包的  --%>
<%--<%@page extends="" %> 控制当前的jsp所生成的Servlet继承自哪个类 --%>
<%--<%@page errorPage="error.jsp" %> 当前页面如果抛出了一个没有被捕获的异常,那么会自动跳转到该页面 --%>
<%-- 指定当前页面是不是用来处理异常的页面,如果为true 那么在java代码中可以使用第9个内置对象--%>
<%--<%@page isErrorPage="true" %>--%>
<%-- 是否忽略 EL表达式 --%>
<%--<%@page isELIgnored="false" %>--%>
<%--<%@taglib prefix=""%> 导入一些自定义的标签 --%>
<%--<%@include file=""%>  导入其他的文件  --%>
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

<!-- JSP java Servlet  Page 
   Jsp 中可以写Java代码
   这个注释是给html的,jsp编译成java文件后,
   也会把这部分内容写入到输出流中
   --!>

<%--
注释:
   注释专门给jsp使用的,编译成Java文件之后,这个是注释不在java文件中,
   也不会在页面中看到
--%>

<%--
   JSP标签
   <%@ %> 写的内容是当前jsp的配置
   下面的三个标签中 都可以写java代码
   <%! %> 这里面的java代码  会生成到类中, 也就是说如果需要定义成员变量,或者成员方法 需要把代码写到这里面
   <%  %> 这里面的java代码  会生成到Service方法中
   <%=  %>  这里面写的是表达式
--%>

<%!
   private int x;
   private int y;

   private int sum(){
       return x + y;
   }
%>

<%
   // 在这里写Java代码
   // 创建一个JSP就会生成一个类
   out.println("Hello JSP");
   out.println("<br>");
   out.println(this.getClass().getName());
   out.println("<br>");
   //输出类文件在硬盘中的路径
   out.println(this.getClass().getResource("").getPath());

//   throw new NullPointerException("随便抛的异常");

   this.x = 10;
   this.y = 18;
   out.println(sum());
%>

<br>
<%
for (int i = 0; i < 10; i++) {
    %>
    <h1>标题<%=i%></h1>
    <%
//    out.println("<h1>标题"+i+"</h1>");
}
%>

</body>
</html>
