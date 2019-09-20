<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<String> list = Arrays.asList("java","html","javaScript","mysql");
        int ran = (int)(Math.random() * list.size());
        String str = list.get(ran);
    %>
    随机的课程：<%=str%>

</body>
</html>
