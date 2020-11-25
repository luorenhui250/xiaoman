package com.numberousfor.xiaoman.config.exception;

import com.numberousfor.xiaoman.config.enums.ErrorEnum;

/**
 * @author cuddly
 * 业务异常类，通过返回码再区分具体错误类型
 * @data 2020/9/24
 */
public class PendingException extends RuntimeException{

    private static final long serialVersionUID = -4424939632221743672L;
    private final String code;

    /**
     * 使用已有的错误类型
     * @param error 枚举中的错误类型
     */
    public PendingException(ErrorEnum error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public String getCode() {
        return code;
    }
}
