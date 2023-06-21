package com.admin.servlet;

/**
 * @author Frailty
 * @date 2023年03月08日 14:22
 */

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.WebListenerRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

/**
 * 1、MyServlet --> /my
 * 2、DispatcherServlet --> /
 */
// (proxyBeanMethods = true)：保证不会产生冗余servlet，保证依赖的组件始终是单实例的
@Configuration(proxyBeanMethods = true)
public class MyRegisterConfig {
    
    @Bean
    public ServletRegistrationBean myServlet(){
        final MyServlet servlet = new MyServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "/my","/my2");
        return servletRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/images/*"));
        return filterRegistrationBean;
    }
    
    @Bean
    public ServletListenerRegistrationBean myListener() {
        final MyContextListener myContextListener = new MyContextListener();
        return new ServletListenerRegistrationBean(myContextListener);
    }
}
