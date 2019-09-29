package com.hxzy.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 获取当前web项目的发布名称，并保存到application作用域
 */
public class GetBasePathListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-----------------GetBasePathListener");

        //当web项目启动时触发的初始化方法
        ServletContext application = sce.getServletContext();
        String contextPath = application.getContextPath();//获取当前项目的发布名称

        application.setAttribute("basePath", contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     //当web项目停止时触发的销毁方法
    }
}
