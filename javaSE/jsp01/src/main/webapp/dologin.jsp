<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //System.out.println("有人访问了dologin.jsp");
    //获取用户的输入
    String account = request.getParameter("account");
    String password = request.getParameter("password");

    System.out.println("用户名：" + account);
    System.out.println("密码：" + password);
    String result = "";
    if(account != null && account.equals("admin") && password != null & password.equals("123456")){
        result = "{\"isSuccess\":true}";
    } else {
        result = "{\"isSuccess\":false}";
    }

    response.setContentType("application/json");
    response.getWriter().write(result);
    response.getWriter().flush(); //刷新缓存
    response.getWriter().close();   //关闭输出流

%>