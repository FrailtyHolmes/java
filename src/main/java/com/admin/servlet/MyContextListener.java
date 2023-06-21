package com.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Frailty
 * @date 2023年03月08日 14:13
 */
@Slf4j
//@WebListener
public class MyContextListener  implements ServletContextListener {
    /*
     * @Description:项目初始化
     * @author Frailty
     * @date 2023/6/17 15:28
     * @param sce 
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听器启动");
    }
    
    /*
     * @Description:项目销毁
     * @author Frailty
     * @date 2023/6/17 15:28
     * @param sce 
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       log.info("监听器销毁");
    }
}
