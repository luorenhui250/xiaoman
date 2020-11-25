package com.numberousfor.xiaoman.config.core;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/9/24
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -8186797667230567093L;
    /**
     * 返回码
     */
    private String code;

    /**
     * 请求成功时返回的对象
     */
    private T date;

    /**
     * 提示信息
     */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
