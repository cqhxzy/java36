package com.hxzy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class AaaFilter1 implements Filter {
    private Logger logger = LoggerFactory.getLogger(AaaFilter1.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("AaaFilter1");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
