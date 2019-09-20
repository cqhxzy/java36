<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
                <a href="addPhone.jsp">新增手机</a>
            </h2>
        </caption>
        <thead>
            <tr>
                <th>品牌</th>
                <th>系列</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                /*模拟测试数据*/
                Map map1 = new HashMap();
                map1.put("brand","华为");
                map1.put("ser","荣耀V9");
                map1.put("price","2333");

                Map map2 = new HashMap();
                map2.put("brand","小米");
                map2.put("ser","红米");
                map2.put("price","1333");

                Map map3 = new HashMap();
                map3.put("brand","apple");
                map3.put("ser","iphone 11");
                map3.put("price","8888");

                List<Map> list = new ArrayList<>();
                list.add(map1);
                list.add(map2);
                list.add(map3);

            %>


            <%
                for (Map map : list) {  /*遍历集合*/

            %>
                <tr>
                    <td><%=map.get("brand")%></td>
                    <td><%=map.get("ser")%></td>
                    <td><%=map.get("price")%></td>
                    <td>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            <%
                }
            %>

        </tbody>
    </table>
</body>
</html>
