package com.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Frailty
 * @date 2023年03月07日 20:49
 */

/**
 * 登录检查
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /*
     * @Description:目标方法执行之前
     * @author Frailty
     * @date 2023/3/7 20:50
     * @param request
     * @param response
     * @param handler 
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();

        Object user = session.getAttribute("loginUser");
        if (user != null){
            return true;
        }

        //拦截住。未登录。跳转到登录页
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request, response); 
        return false;
    }
    
    /*
     * @Description:目标方法执行完成以后
     * @author Frailty
     * @date 2023/3/7 20:50
     * @param null 
     * @return null
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }
    
    /*
     * @Description:页面渲染以后
     * @author Frailty
     * @date 2023/3/7 20:50
     * @param request
     * @param response
     * @param handler
     * @param ex 
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}
