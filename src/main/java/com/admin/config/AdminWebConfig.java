package com.admin.config;

import com.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Frailty
 * @date 2023年03月07日 20:55
 */
/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 *
 * @EnableWebMvc:全面接管
 *      1、静态资源？视图解析器？欢迎页.....全部失效
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /*
     * @Description:将拦截器配置进来
     * @author Frailty
     * @date 2023/6/17 11:47
     * @param registry 
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截包括静态资源，并执行拦截器的规则
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**",
                        "/js/**","/aa/**"); //放行的请求
    }
}
