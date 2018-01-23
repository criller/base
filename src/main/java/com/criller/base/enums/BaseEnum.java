package com.criller.base.enums;

/**
 * 平台基础code
 *
 * @author: CaoCheng
 * @description:
 * @date: Created in 23:18 2018/1/22
 */
public enum BaseEnum {
    NOT_FOUND(404, "资源不存在"),;
    private int code;
    private String message;

    BaseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

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

}
