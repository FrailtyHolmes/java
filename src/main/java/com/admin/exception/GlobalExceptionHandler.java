package com.admin.exception;

/**
 * @author Frailty
 * @date 2023年03月08日 13:56
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})//处理数学运算异常以及空指针异常
    public String handleException(Exception e) {
        log.error("异常是：{}",e);
        return "login";//视图地址
    }
    
}
