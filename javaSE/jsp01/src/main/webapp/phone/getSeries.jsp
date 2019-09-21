<%@ page import="com.hxzy.biz.SeriesBiz" %>
<%@ page import="com.hxzy.biz.impl.SeriesBizImpl" %>
<%@ page import="com.hxzy.entity.Series" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%--
    JSP注释

    这个页面不需要编写html标签，因为只是通过这个页面实现查询系列的数据，
    并将系列转换为json格式的字符串。最终将json响应给addPhone.jsp
--%>
<%
    String brandId = request.getParameter("brandId"); //从请求中获取brandId，注意，返回的是一个字符串
    Integer id = Integer.valueOf(brandId); //将字符串转换为Integer对象

    //根据品牌编号查询系列

    SeriesBiz seriesBiz = new SeriesBizImpl();
    List<Series> list = seriesBiz.findSeriesByBrandId(id);

    //通过阿里巴巴的fastjson将集合转换为字符串
    String json = JSONObject.toJSONString(list);

    //将json响应给客户端。（addPhone.jsp）
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(json);
    response.getWriter().flush();
    response.getWriter().close();

%>