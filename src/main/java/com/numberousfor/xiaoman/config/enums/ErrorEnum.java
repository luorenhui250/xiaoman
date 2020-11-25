package com.numberousfor.xiaoman.config.enums;

/**
 * @author cuddly
 * @data 2020/9/24
 */
public enum ErrorEnum {
    /**
     * 自定义异常枚举
     */
    SYSTEM_EXCEPTION("R6001", "系统异常"),
    SEARCH_BOOK_NAME_IS_BLANK("R6002", "请输入小说名称");

    private final String code;

    private final String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
