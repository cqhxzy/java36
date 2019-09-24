package com.hxzy.servlet;

import com.hxzy.entity.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test5_forward")
public class TestServlet5_forward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brands = (List<Brand>) request.getAttribute("brands");

        System.out.println("集合长度：" + brands.size());
    }
}
