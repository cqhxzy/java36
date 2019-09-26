package com.hxzy.servlet;

import com.hxzy.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sys/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageContext作用域
        PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 8192, true);

        pageContext.setAttribute("name","page_admin");
        req.setAttribute("name","request_zhangsan");  //向request作用域中添加了数据

        //向session作用域中添加name
        HttpSession session = req.getSession();
        session.setAttribute("name","session_lisi");

        //向application作用域中添加name
        ServletContext application = req.getServletContext();
        application.setAttribute("name","application_wangwu");

        User user1 = new User(888,"admin",18,"渝中区","123456");
        User user2 = new User(99,"张三",18,"九龙坡区","123456");
        //将对象添加到request作用域

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        req.setAttribute("list", list);
        System.out.println(req.getContextPath());
        System.out.println("request encoding：" + req.getCharacterEncoding());
        System.out.println("response encoding：" + resp.getCharacterEncoding());
        //页面转发
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
