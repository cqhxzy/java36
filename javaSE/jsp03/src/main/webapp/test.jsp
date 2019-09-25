<%@ page import="java.util.Arrays" %>
<%@ page import="com.hxzy.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/25 0025
  Time: 下午 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导入jstl核心库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试页</title>
</head>
<body>
    <%
        pageContext.setAttribute("num",2);

        List<User> users = Arrays.asList(
                new User(1, "test1", 18, "渝中区1"),
                new User(2, "test2", 18, "渝中区2"),
                new User(3, "test3", 18, "渝中区3"),
                new User(4, "test4", 18, "渝中区4")
        );

        pageContext.setAttribute("users",users);
    %>
    <!--类似于java中的if判断-->
    <c:if test="${1==2}">true</c:if>

    <!--类似于java中的switch-->
    <c:choose>
        <c:when test="${num == 1}">
            1
        </c:when>
        <c:when test="${num == 10}">
            10
        </c:when>
        <c:otherwise>
            other
        </c:otherwise>
    </c:choose>

    <ul>
        <!--
            begin:循环变量初识值
            end:循环的结束值
            循环条件：begin <= end
            step:循环变量值改变

            for(int i = 10;i <= 14;i++)
        -->
        <c:forEach begin="10" end="14" step="1" varStatus="status">
            <li>value：${status.index}  count： ${status.count}</li>  <!--调用getIndex() 得到当前的下标对应的值-->
        </c:forEach>
    </ul>

    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>地址</td>
        </tr>
        <!--
            for(User item : users)
        -->
        <c:forEach var="user" items="${users}" varStatus="status">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
