package com.hxzy.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet的生命周期
 */
public class TestServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(TestServlet.class.getName() + "执行初始化的方法");

        String encoding = config.getInitParameter("encoding");
        System.out.println("初始化servlet参数：" + encoding);
    }

    @Override
    public void init() throws ServletException {
        super.init();


    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);

        HttpServletRequest request = (HttpServletRequest) req;
        String method = request.getMethod();//获取当前的请求方式
        System.out.println("请求方式：" + method);

        System.out.println(this.getClass().getName() + "执行service方法," + LocalDateTime.now().toString());
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(this.getClass().getName() + "执行销毁的方法");
    }
}
