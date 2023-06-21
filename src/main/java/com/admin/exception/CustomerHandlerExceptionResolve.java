package com.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Frailty
 * @date 2023年03月08日 14:01
 */
//@Order(value = Ordered.HIGHEST_PRECEDENCE) //优先级，数字越小优先级越高
@Component
//exception底层执行为遍历执行，所以同一类型错误，先捕获就先执行
public class CustomerHandlerExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, 
                                         Exception ex) {
        try {
            response.sendError(511,"我的错误"); //自定义错误以及错误信息
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
