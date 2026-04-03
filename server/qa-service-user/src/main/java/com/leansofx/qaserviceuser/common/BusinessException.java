package com.leansofx.qaserviceuser.common;

import com.leansofx.qaserviceuser.common.base.IErrorCode;
import com.leansofx.qaserviceuser.common.base.ResultCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述: 业务异常类 Http返回码为200
 * 如需要自定义业务异常类，请继承重写对应逻辑
 * @author maolu
 */
@Slf4j
public class BusinessException extends RuntimeException {


    public String code;

    public String message;

    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable ex) {
        super(message, ex);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    public BusinessException(String code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
    }

    public BusinessException(IErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public BusinessException(IErrorCode errorCode, Throwable ex) {
        this(errorCode.getCode(), errorCode.getMessage(), ex);
    }
}
