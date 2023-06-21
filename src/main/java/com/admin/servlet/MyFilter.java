package com.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Frailty
 * @date 2023年03月08日 14:10
 */

@Slf4j
//@WebFilter({"/css/*","/images/*"}) 
// “/*”适用与Spring，“/**”适用于SpringMvc
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化完成");
    }

    @Override
    public void destroy() {
        log.info("销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("工作");
        filterChain.doFilter(servletRequest,servletResponse); //filter工作固定写法
    }
}
