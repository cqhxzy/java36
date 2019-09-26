package com.hxzy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(EncodingFilter.class);
    private String encoding = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("--------------------初始化EncodingFilter--------------------");
        encoding = filterConfig.getInitParameter("encoding");
        //logger.info("Filter初始化参数：" + encoding);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding); //设置请求的查询编码
        response.setCharacterEncoding(encoding);//设置响应的查询编码
        logger.info("----------------------EncodingFilter");
        chain.doFilter(request,response);//放行
    }

    @Override
    public void destroy() {
        System.out.println("--------------------销毁EncodingFilter--------------------");
    }
}
