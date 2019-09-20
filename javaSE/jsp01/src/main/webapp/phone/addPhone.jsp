<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增手机</title>
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
        tr{
            line-height: 50px;
        }
        td:last-child{
            text-align: left;
            padding-left: 10px;
        }

        tr:last-child td{
            text-align: center;
        }

    </style>
</head>
<body>
    <form method="post" action="/phone/doAddPhone.jsp">
        <table>
            <caption>
                <h2>新增手机</h2>
            </caption>
            <tr>
                <td>品牌</td>
                <td>
                    <input type="text" name="brand" />
                </td>
            </tr>
            <tr>
                <td>系列</td>
                <td>
                    <input type="text" name="ser" />
                </td>
            </tr>
            <tr>
                <td>价格</td>
                <td>
                    <input type="text" name="price" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">提交</button>
                </td>
            </tr>
        </table>

    </form>
</body>
</html>
