package com.yruns.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ProjectExceptionAdvice,springmvc异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        // 记录日志
        ex.printStackTrace();
        return new Result(Code.SYSTEM_ERR, false, "服务器异常，请稍后再试。");
    }
}
