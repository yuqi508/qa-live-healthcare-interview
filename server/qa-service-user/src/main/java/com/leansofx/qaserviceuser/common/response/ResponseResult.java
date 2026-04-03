package com.leansofx.qaserviceuser.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leansofx.qaserviceuser.common.base.IErrorCode;
import com.leansofx.qaserviceuser.common.base.ResultCode;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -1241360949457314497L;

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String traceId;

    public ResponseResult() {
    }

    public ResponseResult(String code, String message) {
        this(code, message, null);
    }

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T t) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), t);
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), message);
    }

    public static <T> ResponseResult<T> failed(IErrorCode errorCode) {
        return new ResponseResult(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> ResponseResult<T> failed(String code, String message) {
        return new ResponseResult(code, message);
    }

    public static <T> ResponseResult<T> failed(String message) {
        return new ResponseResult(ResultCode.FAILED.getCode(), message);
    }


    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseModel [result=" + this.data +  ", message=" + this.message + ", code=" + this.code + "]";
    }

}
