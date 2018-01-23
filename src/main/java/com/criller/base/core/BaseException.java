package com.criller.base.core;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 23:00 2018/1/22
 */
public class BaseException extends RuntimeException {
    private int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(Throwable cause, int code, String message) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
