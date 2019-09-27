<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/26 0026
  Time: 上午 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form method="post" action="<%=request.getContextPath()%>/login">
        <table>
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" name="loginName" value="${loginName}" />
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" name="loginPwd" value="${loginPwd}" />
                </td>
            </tr>
            <tr>
                <td><label><input type="checkbox" name="rememberMe" ${remember?"checked":""} />记住我</label></td>
                <td><label><input type="checkbox" />自动登录</label></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>登录</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
