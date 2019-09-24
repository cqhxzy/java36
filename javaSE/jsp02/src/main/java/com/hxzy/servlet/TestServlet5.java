package com.hxzy.servlet;

import com.hxzy.biz.BrandBiz;
import com.hxzy.biz.impl.BrandBizImpl;
import com.hxzy.entity.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test5")
public class TestServlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //查询所有的品牌信息
        BrandBiz brandBiz = new BrandBizImpl();
        List<Brand> brands = brandBiz.queryAll();

        //将集合添加到request作用域中
        request.setAttribute("brands",brands);

        //跳转servlet的同时，并且将数据传递到test5_forward servlet中去。
        request.getRequestDispatcher("/test5_forward").forward(request,response);
    }
}