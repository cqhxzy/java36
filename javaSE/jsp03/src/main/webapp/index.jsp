<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/25 0025
  Time: 上午 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p> 1 + 2 = ${1+2}</p>
    <p> 1 * 2 = ${1*2}</p>
    <p> 1 / 2 = ${1/2}</p>
    <p> 1 - 2 = ${1-2}</p>
    <p> 1&gt;2: ${1>2}</p>
    <p> 1&lt;2: ${1<2}</p>
    <p> true && true: ${true && true}</p>
    <p> true || true: ${true || true}</p>
    <%
        pageContext.setAttribute("name","page_zhaoliu");
    %>
    <!--从pageContext作用域中获取键为name的值-->
    <p>${pageScope.name}</p>
    <p>${requestScope.name}</p>
    <p>${sessionScope.name}</p>
    <p>${applicationScope.name}</p>
  <%--  <p>编号：${user.id}</p>
    <p>姓名：${user.name}</p>
    <p>年龄：${user.age}</p>
    <p>地址：${user.address}</p>--%>


</body>
</html>
