<%@ page import="com.hxzy.entity.Phone" %>
<%@ page import="com.hxzy.biz.PhoneBiz" %>
<%@ page import="com.hxzy.biz.impl.PhoneBizImpl" %>
<%

    String brand = request.getParameter("brand");//获取品牌
    String ser = request.getParameter("ser"); //获取系列
    String str_price = request.getParameter("price"); //获取价格
    //如果价格不为空，就将价格转换类型，否则给默认值0
    double price = str_price == null || str_price.equals("") ? 0 : new Double(str_price);

    //将数据组件称为phone的对象
     Phone phone = new Phone(0, brand, ser, price);

    //调用业务逻辑层，将组件好的phone对象通过insert方法保存到数据库

    PhoneBiz phoneBiz = new PhoneBizImpl();

    //根据业务逻辑层返回的结果，告诉用户添加信息（成功，失败）
    int insert = phoneBiz.insert(phone);

    //成功回到首页，失败，仍然留着新增页面
    if (insert > 0) {
        response.sendRedirect("/phone/phonelist.jsp");
    } else {
        response.sendRedirect("/phone/addPhone.jsp");
    }

%>