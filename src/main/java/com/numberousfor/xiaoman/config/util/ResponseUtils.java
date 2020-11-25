package com.numberousfor.xiaoman.config.util;

import com.numberousfor.xiaoman.config.core.Result;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/9/24
 */
public class ResponseUtils implements Serializable {
    private static final long serialVersionUID = -8076228331709635342L;

    private static final String SUCCESS = "success";

    public static Result success(Object obj){
        Result rs = new Result();
        rs.setCode("00000");
        rs.setMessage(SUCCESS);
        rs.setDate(obj);
        return rs;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String code, String message) {
        Result rs = new Result();
        rs.setCode(code);
        rs.setMessage(message);
        return rs;
    }

}
