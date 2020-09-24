package com.numberousfor.xiaoman.core;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/5/5 下午5:16
 */
public interface DTO extends Serializable {
    /**
     * 返回码
     * @return
     */
    public String getCode();

    /**
     * 返回码描述
     * @return
     */
    public String getMessage();

    /**
     * 返回信息
     * @return
     */
    public String getData();
}
