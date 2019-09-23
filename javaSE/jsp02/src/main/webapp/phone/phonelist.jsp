<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hxzy.entity.Phone" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机</title>

    <style>

        table{
            width: 500px;
            text-align: center;
            margin: 0 auto;
        }
        table,td,th{
            border: 1px solid black;
            border-collapse: collapse;
        }

        caption h2{
            position: relative;
        }
        caption h2 a{
            position: absolute;
            right: 0;
            bottom: 0;
            font: normal normal 16px "微软雅黑";
        }
    </style>
</head>
<body>
    <table>
        <caption>
            <h2>
                手机信息
                <!--
                    在前端页面中，路径中的/代表着tomcat webapps根目录

                    在后端java代码开发中，/代表着webapp目录。
                -->
                <%
                    String contextPath = request.getContextPath();
                %>
                <a href="<%=contextPath%>/phone/addPhone.jsp">新增手机</a>
            </h2>
        </caption>
        <thead>
            <tr>
                <th>品牌</th>
                <th>系列</th>
                <th>系统</th>
                <th>网络类型</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%--<%
                /*模拟测试数据*/
                Phone huawei = new Phone(1, "华为", "荣耀V9", 2333.0);
                Phone mi = new Phone(2, "小米", "红米", 2333.0);
                Phone iphone = new Phone(3, "apple", "iphone 11", 2333.0);

                List<Phone> list = new ArrayList<>();
                list.add(huawei);
                list.add(mi);
                list.add(iphone);

            %>


            <%
                for (Phone phone : list) {  /*遍历集合*/

            %>
                <tr>
                    <td><%=phone.getBrand()%></td>
                    <td><%=phone.getSer()%></td>
                    <td><%=phone.getPrice()%></td>
                    <td>
                        <a href="<%=contextPath%>/phone/updatePhone.jsp?id=<%=phone.getId()%>">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            <%
                }
            %>--%>

        </tbody>
    </table>
</body>
</html>
