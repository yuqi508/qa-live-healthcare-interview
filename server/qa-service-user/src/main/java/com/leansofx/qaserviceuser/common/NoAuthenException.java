package com.leansofx.qaserviceuser.common;

import com.leansofx.qaserviceuser.common.base.IErrorCode;
import com.leansofx.qaserviceuser.common.base.ResultCode;

public class NoAuthenException extends RuntimeException{

    public String code;
    public String message;

    public NoAuthenException(String message) {
        super(message);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    public NoAuthenException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public NoAuthenException(String message, Throwable ex) {
        super(message, ex);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    public NoAuthenException(String code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
    }

    public NoAuthenException(IErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public NoAuthenException(IErrorCode errorCode, Throwable ex) {
        this(errorCode.getCode(), errorCode.getMessage(), ex);
    }
}
