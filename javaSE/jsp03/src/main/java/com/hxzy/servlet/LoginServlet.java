package com.hxzy.servlet;

import com.hxzy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //登录
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");

        List<User> users = Arrays.asList(
                new User(1, "admin", 18, "test", "123456"),
                new User(2, "zhangsan", 18, "test", "123456"),
                new User(3, "lisi", 18, "test", "123456"),
                new User(4, "wangwu", 18, "test", "123456")
                );

        List<User> collect = users.stream().filter(t -> t.getName().equals(loginName) && t.getPassword().equals(loginPwd))
                .collect(Collectors.toList());
        if (collect.size() > 0) { //用户名密码正确
            User user = collect.get(0);//用户名不可能重复
            //将用户保存到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            logger.info("登录成功，保存用户信息至session");
            //重定向
            response.sendRedirect(request.getContextPath() + "/sys/index");
        } else {
            logger.error("登录失败，重定向到首页");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}
