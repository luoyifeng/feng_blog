package com.jd.popc.controller;

import com.jd.com.base.exception.InvalidParamException;
import com.jd.com.base.exception.UserNotLoginException;
import com.jd.com.base.response.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.SQLException;

import static com.jd.common.constant.ErrorCode.*;


/**
 * Created by yangsong
 */
@Slf4j
public class BaseController {

    /**
     * @param object
     * @param paramName
     * @throws InvalidParamException 同时校验多个参数是否都存在
     */
    public static void checkParams(Object object, String... paramName) throws InvalidParamException {
        if (object == null) {
            throw new InvalidParamException(null);
        }

        for (String name : paramName) {
            try {
                String value = BeanUtils.getProperty(object, name);
                if (StringUtils.isBlank(value)) {
                    throw new InvalidParamException(name);
                }
            } catch (Exception e) {
                throw new InvalidParamException(name);
            }
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody
    ServiceResponse handleRuntimeException(RuntimeException e) {
        String message = e.getMessage();
        log.error("系统运行时异常", e);
        return ServiceResponse.failure(SYS_RUNTIME, "系统运行时异常:" + message);
    }

    /**
     * 空指针异常     *
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ServiceResponse nullPointerExceptionHandler(NullPointerException e) {
        log.error("空指针异常", e);
        return ServiceResponse.failure(SYS_NULL_POINT, "空指针异常:" + e.getMessage());
    }

    /**
     * 类型转换异常
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ServiceResponse<Object> classCastExceptionHandler(ClassCastException e) {
        log.error("类型转换异常", e);
        return ServiceResponse.failure(SYS_CLASS_CAST, "类型转换异常:" + e.getMessage());
    }

    /**
     * IO异常
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ServiceResponse<Object> iOExceptionHandler(IOException e) {
        log.error("IO异常", e);
        return  ServiceResponse.failure(SYS_IO, "IO异常:" + e.getMessage());
    }

    /**
     * 未知方法异常
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public ServiceResponse<Object> noSuchMethodExceptionHandler(NoSuchMethodException e) {
        log.error("未知方法异常", e);
        return ServiceResponse.failure(SYS_NO_METHOD, "未知方法异常:" + e.getMessage());
    }

    /**
     * 数组越界异常
     * @param e
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ServiceResponse<Object> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        log.error("数组越界异常", e);
        return ServiceResponse.failure(SYS_INDEX_OUT_BOUNDS, "数组越界异常:" + e.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public @ResponseBody
    ServiceResponse<Object> handleSQLException(SQLException e) {
        log.error("SQL查询错误", e);
        return ServiceResponse.failure(THR_DB_ERR, "SQL查询错误:" + e.getMessage());
    }


    /**
     * 400错误,参数类型不匹配
     * @param e
     * @return
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public ServiceResponse<Object> requestTypeMismatch(TypeMismatchException e) {
        log.warn("参数类型不匹配", e);
        String requiredType = e.getRequiredType().getName();
        String propertyName = e.getPropertyChangeEvent() == null ? "" : e.getPropertyChangeEvent().getPropertyName();
        return ServiceResponse.failure(REQ_PARAM_TYPE_NOT_MATCH, "参数[" + propertyName + "]类型应为[" + requiredType + "]");
    }

    /**
     * 400错误,无效参数
     * @param e
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ServiceResponse<Object> requestMissingServletRequest(MissingServletRequestParameterException e) {
        log.warn("无效参数", e);
        return handleInvalidParamException(new InvalidParamException(e.getParameterName()));
    }

    @ExceptionHandler(InvalidParamException.class)
    public @ResponseBody
    ServiceResponse<Object> handleInvalidParamException(InvalidParamException e) {
        log.warn("无效参数", e);
        return ServiceResponse.failure(REQ_INVALID_PARAM, "无效参数:" + e.getMessage());
    }

    @ExceptionHandler(UserNotLoginException.class)
    public @ResponseBody
    ServiceResponse<Object> handleUserNotLoginException(UserNotLoginException e) {
        log.error("用户未登陆", e);
        return ServiceResponse.failure(USER_NOT_LOGIN, "用户未登陆:" + e.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public ServiceResponse handleErrorMultipartException(MultipartException e) {
        log.error("upload file error, ", e);
        return ServiceResponse.failure(e.getCause().getMessage());
    }

    public String getOfficerNoByCookie(Cookie[] cookies, String cookieName) {
        String officerNo = null;
        try {
            if(cookies != null && cookies.length > 0) {
                for(Cookie cookie: cookies) {
                    log.info("cookie name:{}, value:{}", cookie.getName(), cookie.getValue());
                    if(cookie.getName().equals(cookieName)) {
                        officerNo = cookie.getValue();
                        log.info("get officerNo from cookie success:", officerNo);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            log.error("get officerNo from cookies info error", e);
        }

        return officerNo;
    }
}
