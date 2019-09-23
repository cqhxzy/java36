package com.hxzy.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.SeriesBiz;
import com.hxzy.biz.impl.SeriesBizImpl;
import com.hxzy.entity.Series;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//为GetSeriesServlet 设置url pattern
@WebServlet("/phone/getSeries")
public class GetSeriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
