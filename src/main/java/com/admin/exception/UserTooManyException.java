package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Frailty
 * @date 2023年03月08日 13:50
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多") //value表示该异常的状态码
public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
