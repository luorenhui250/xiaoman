package com.numberousfor.xiaoman.config.handler;

import com.numberousfor.xiaoman.config.exception.PendingException;
import com.numberousfor.xiaoman.config.core.Result;
import com.numberousfor.xiaoman.config.util.ResponseUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cuddly
 * @data 2020/9/24
 */
@ControllerAdvice
public class PendingExceptionHandler {

    /**
     * ExceptionHandler相当于controller的@RequestMapping
     * 如果抛出的异常是PendingException，则调用该方法
     * @param e
     * @return
     */
    @ExceptionHandler(PendingException.class)
    @ResponseBody
    public Result<?> handle(PendingException e) {
        return ResponseUtils.error(e.getCode(), e.getMessage());
    }

}
