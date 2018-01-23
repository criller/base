package com.criller.base.core;

/**
 * 接口统一返回对象
 *
 * @author: CaoCheng
 * @description:
 * @date: Created in 22:41 2018/1/22
 */
public class Result {
    /**
     * 统一返回code
     */
    private int code;
    /**
     * 统一返回信息
     */
    private String message;
    /**
     * 统一返回数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
