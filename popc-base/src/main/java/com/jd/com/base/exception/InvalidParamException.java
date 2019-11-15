package com.jd.com.base.exception;

/**
 * @author yangsong
 */
public class InvalidParamException extends RuntimeException {

    private String paramName;

    public InvalidParamException(String paramName) {
        this.paramName = paramName;
    }

    public InvalidParamException(String paramName, Throwable e) {
        super(e);
        this.paramName = paramName;
    }

    @Override
    public String getMessage() {
        return "参数[" + (this.paramName != null ? this.paramName : "") + "]值为空";
    }
}
