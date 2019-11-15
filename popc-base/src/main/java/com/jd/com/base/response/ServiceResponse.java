package com.jd.com.base.response;

import lombok.Data;

import java.io.Serializable;


/**
 * @author yangsong
 */
@Data
public class ServiceResponse<T> implements Serializable {

    private static final long serialVersionUID = 2488663702267110932L;
    private int code;
    private String msg;
    private String detail;
    private T data;
    private Integer totalSize;
    private Integer currentPage;

    public static ServiceResponse<BaseResponseEnum> successResponse() {
        return new ServiceResponse<BaseResponseEnum>(BaseResponseEnum.SUCCESS);
    }

    public static ServiceResponse<BaseResponseEnum> failureResponse() {
        return new ServiceResponse<BaseResponseEnum>(BaseResponseEnum.FAILURE);
    }

    public static <T> ServiceResponse<T> illegalArg(T data) {
        return new ServiceResponse<T>(data, BaseResponseEnum.FAILURE.getCode(), BaseResponseEnum.PARAM_ERROR.getMsg());
    }

    public static <T> ServiceResponse<T> ok(T data) {
        return new ServiceResponse<T>(data);
    }

    public static <T> ServiceResponse<T> success(T data) {
        return ok(data);
    }

    public static <T> ServiceResponse<T> successWithPageInfo(T data, Integer currentPage, Integer totalSize) {
        return new ServiceResponse(data, currentPage, totalSize);
    }

    public static <T> ServiceResponse<T> failure() {
        return failure(BaseResponseEnum.FAILURE.getMsg());
    }

    public static <T> ServiceResponse<T> failure(String msg) {
        return failure(BaseResponseEnum.FAILURE.getCode(), msg);
    }

    public static <T> ServiceResponse<T> failureBussiness(String msg) {
        return failure(null, BaseResponseEnum.FAILURE_BUSSINES.getCode(), msg);
    }

    public static <T> ServiceResponse<T> failure(int code, String msg) {
        return failure(null, code, msg);
    }

    public static <T> ServiceResponse<T> failure(T data, int code, String msg) {
        return new ServiceResponse<>(data, code, msg);
    }


    public ServiceResponse(Integer code, T data, String msg, String detail) {
        if (code != null) {
            this.code = code;
        }
        this.data = data;
        this.msg = msg;
        this.detail = detail;
    }

    public ServiceResponse(Integer code, T data, String msg, String detail, Integer currentPage, Integer totalSize) {
        if (code != null) {
            this.code = code;
        }
        this.data = data;
        this.msg = msg;
        this.detail = detail;
        this.currentPage = currentPage;
        this.totalSize = totalSize;
    }

    public ServiceResponse(T data, BaseResponseEnum responseEnum, String detail) {
        this(responseEnum.getCode(), data, responseEnum.getMsg(), detail);
    }

    public ServiceResponse(T data) {
        this(data, BaseResponseEnum.SUCCESS, null);
    }

    public ServiceResponse(T data, BaseResponseEnum responseEnum, String detail, Integer currentPage, Integer totalSize) {
        this(responseEnum.getCode(), data, responseEnum.getMsg(), detail, currentPage, totalSize);
    }

    public ServiceResponse(T data, Integer currentPage, Integer totalSize) {
        this(data, BaseResponseEnum.SUCCESS, null, currentPage, totalSize);
    }

    public ServiceResponse(T data, String msg) {
        this(null, data, msg, null);
    }

    public ServiceResponse(T data, int code, String msg) {
        this(code, data, msg, null);
    }

    public ServiceResponse(int code, String msg) {
        this(code, null, msg, null);
    }

    public ServiceResponse() {
        this(null, BaseResponseEnum.SUCCESS, null);
    }


}