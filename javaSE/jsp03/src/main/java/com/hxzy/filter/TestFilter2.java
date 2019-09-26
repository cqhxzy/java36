package com.hxzy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class TestFilter2 implements Filter {
    private Logger logger = LoggerFactory.getLogger(TestFilter2.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("TestFilter2");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
