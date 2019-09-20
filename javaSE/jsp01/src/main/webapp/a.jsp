<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //页面转发
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("b.jsp");

        response.setHeader("Date","2019-09-20 17:06");
        requestDispatcher.forward(request,response);
    %>
</body>
</html>
