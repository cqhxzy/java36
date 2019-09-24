package com.hxzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println(session.getClass().getName());
        String user = (String) session.getAttribute("user");

        response.setCharacterEncoding("utf-8"); //设置response查询编码为utf-8
        response.setContentType("text/html;charset=UTF-8"); //设置响应的MIME类型
        StringBuilder builder = new StringBuilder();
        builder.append("<html>")
                .append("<head>")
                .append("<meta charset=\"utf-8\" />")
                .append("<title>")
                .append("servlet产生的页面")
                .append("</title>")
                .append("</head>")
                .append("<body>")
                .append("<p>sessionId:"+session.getId()+"</p>")
                .append("<p>user:"+user+"</p>")
                .append("</body>")
                .append("</html>");

        //使session立即失效
        session.invalidate();

        PrintWriter out = response.getWriter();
        out.write(builder.toString());
        out.flush();
        out.close();

    }
}
