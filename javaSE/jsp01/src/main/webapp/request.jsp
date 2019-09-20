<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        String contextPath = request.getContextPath();//获取当前项目的发布名称
        Enumeration<String> headerNames = request.getHeaderNames(); //获取请求头信息

        StringBuilder builder = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            builder.append(s + ",");
        }

        String method = request.getMethod();//获取当前的请求方式

        String queryString = request.getQueryString();//获取请求字符串
    %>

    <p>
        contextPath:<%=contextPath%>  <!--引用变量-->
    </p>
    <p>
        请求头:<%=builder.toString()%>
    </p>
    <p>
        请求方式：<%=method%>
    </p>
    <p>
        请求字符串：<%=queryString%>
    </p>
    <p>
        sessionId:<%=request.getRequestedSessionId()%>
    </p>
    <p>
        requestURI:<%=request.getRequestURI()%>
    </p>
    <p>
        servletPath:<%=request.getServletPath()%>
    </p>
    <p>
        请求参数account的值：<%=request.getParameter("account")%>
    </p>
    <p>
        请求参数password的值：<%=request.getParameter("password")%>
    </p>
    <p>
        协议版本：<%=request.getProtocol()%>
    </p>
    <p>
        客户端IP地址：<%=request.getRemoteAddr()%>
    </p>
    <p>
        客户端HOST：<%=request.getRemoteHost()%>
    </p>
    <p>
        协议：<%=request.getScheme()%>
    </p>
    <p>
        服务器的主机名：<%=request.getServerName()%>
    </p>
    <p>
        服务器的端口号：<%=request.getServerPort()%>
    </p>

</body>
</html>
