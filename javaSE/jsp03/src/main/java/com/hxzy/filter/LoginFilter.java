package com.hxzy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-------------------LoginFilter执行init方法-----------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //logger.info("拦截到请求");
        logger.info("----------------------LoginFilter");
        //验证用户是否登录
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);//有则获取，无则返回null
        if (session != null) {
            Object user = session.getAttribute("user");
            if (user == null) { //没有登录
                //重定向到登录页
                logger.error("用户没有登录，重定向到登录页");
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            } else {
                //登录了
                logger.info("用户已经登录，放行请求");
                chain.doFilter(req,resp); //发型请求到下一个过滤器
                return;
            }
        }
        logger.error("服务器没有关于当前请求的session");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
        return;
    }

    @Override
    public void destroy() {

    }
}
