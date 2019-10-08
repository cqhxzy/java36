package com.hxzy.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/page/sys/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user + "====================================");
        if (user == null) { //没有登录
            resp.sendRedirect(((HttpServletRequest) request).getContextPath() + "/page/login.jsp");
        } else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
