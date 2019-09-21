<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="java.util.*" %>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 2:38
  To change this template use File | Settings | File Templates.
--%>
<%
    Map book1 = new HashMap();
    book1.put("image","https://img3.doubanio.com/lpic/s3435132.jpg");
    book1.put("author","陈儒");
    book1.put("title","Python源码剖析");
    book1.put("fav_nums", 0);

    Map book2 = new HashMap();
    book2.put("image","https://img3.doubanio.com/lpic/s3435132.jpg");
    book2.put("author","陈儒");
    book2.put("title","Python源码剖析");
    book2.put("fav_nums", 0);

    Map book3 = new HashMap();
    book3.put("image","https://img3.doubanio.com/lpic/s3435132.jpg");
    book3.put("author","陈儒");
    book3.put("title","Python源码剖析");
    book3.put("fav_nums", 0);

    List<Object> list = new ArrayList<>();
    list.add(book1);
    list.add(book2);
    list.add(book3);
    String str = JSONObject.toJSONString(list);//将集合转换为json字符串
    System.out.println(str);
    response.getWriter().write(str); //将json字符串输出到客户端
    response.getWriter().flush();
    response.getWriter().close();
%>