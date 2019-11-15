package com.jd.com.base.exception;

public class UserNotLoginException extends RuntimeException {

    public UserNotLoginException() {
        super("用户未登录");
    }
}
