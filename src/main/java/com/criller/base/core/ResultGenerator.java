package com.criller.base.core;

import org.springframework.http.HttpStatus;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(Object data) {
        Result result = genSuccessResult();
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMessage(message);
        return result;
    }

    public static Result genNotFoundResult(String message) {
        Result result = new Result();
        result.setCode(HttpStatus.NOT_FOUND.value());
        result.setMessage(message);
        return result;
    }
}