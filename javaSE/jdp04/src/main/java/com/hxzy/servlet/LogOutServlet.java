package com.hxzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 退出系统
 */
@WebServlet("/page/sys/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //退出系统，应该要删除当前登录的用户信息
        HttpSession session = request.getSession();
        //session.removeAttribute("user"); 从session中移除键为user的对象，用作退出系统的功能不太好
        session.invalidate(); //使session对象立即失效


        //页面重定向到登录页
        response.sendRedirect(request.getContextPath() + "/page/login.jsp");
    }
}
