<%@ page import="com.hxzy.entity.Phone" %>
<%@ page import="com.hxzy.biz.PhoneBiz" %>
<%@ page import="com.hxzy.biz.impl.PhoneBizImpl" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.hxzy.entity.Series" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%

    String str_ser = request.getParameter("series"); //获取系列
    String str_os = request.getParameter("os"); //系统
    String[] networkModels = request.getParameterValues("networkModel");
    String str_price = request.getParameter("price"); //获取价格
    //如果价格不为空，就将价格转换类型，否则给默认值0
    double price = str_price == null || str_price.equals("") ? 0 : new Double(str_price);

    Integer series = new Integer(str_ser);//将系列转换为Integer
    Integer os = new Integer(str_os);//将系统转换为Integer

    Integer networkModel = null;
    if (networkModels != null) {
        Arrays.sort(networkModels); //对字符串的网络模式排序
        String max = networkModels[networkModels.length - 1];//去网络模型中的最大值
        networkModel = new Integer(max);
    }

    //将数据组件称为phone的对象

    Phone phone = new Phone(0, new Series(series), os, networkModel, price);

    //调用业务逻辑层，将组件好的phone对象通过insert方法保存到数据库

    PhoneBiz phoneBiz = new PhoneBizImpl();

    //根据业务逻辑层返回的结果，告诉用户添加信息（成功，失败）
    int insert = phoneBiz.insert(phone);

    //成功回到首页，失败，仍然留着新增页面
    Map map = new HashMap();
    if (insert > 0) {
        map.put("result",true);
    } else {
        map.put("result",false);
    }

    //将map转换为json
    String json = JSONObject.toJSONString(map);

    //将json响应给客户端
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(json);
    response.getWriter().flush();
    response.getWriter().close();
%>