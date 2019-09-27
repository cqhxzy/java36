package com.hxzy.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CookieFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //从request对象中获取cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            HttpSession session = req.getSession();

            String loginName = null;
            String loginPwd = null;
            String remember = null;

            for (Cookie cookie : cookies) {
                //将缓存的用户名和密码保存到本次会话中
                if (cookie.getName().equals("loginName")) loginName = cookie.getValue();
                if (cookie.getName().equals("loginPwd")) loginPwd = cookie.getValue();
                if (cookie.getName().equals("remember")) remember = cookie.getValue();
            }

            if (remember != null && remember.equals("true")){
                session.setAttribute("loginName",loginName);
                session.setAttribute("loginPwd",loginPwd);
                session.setAttribute("remember",true);
            }
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
