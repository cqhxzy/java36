package com.hxzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println(TestServlet2.class.getName() + " 得到了一次用户发起的Get请求");
        String name = Thread.currentThread().getName();
        String remoteAddr = request.getRemoteAddr(); //发起请求的用户的id地址
        System.out.println("处理当前请求的线程名：" + name + ",用户的IP地址：" + remoteAddr);

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }

        response.setCharacterEncoding("utf-8"); //设置response查询编码为utf-8
        response.setContentType("text/html;charset=UTF-8"); //设置响应的MIME类型
        StringBuilder builder = new StringBuilder();
        builder.append("<html>")
                .append("<head>")
                .append("<meta charset=\"utf-8\" />")
                .append("servlet产生的页面")
                .append("<title>")
                .append("</title>")
                .append("</head>")
                .append("<body>")
                .append("1-100累加的和：" + sum)
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.write(builder.toString());
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TestServlet2.class.getName() + " 得到了一次用户发起的post请求");
        //super.doPost(req, resp);
    }
}
