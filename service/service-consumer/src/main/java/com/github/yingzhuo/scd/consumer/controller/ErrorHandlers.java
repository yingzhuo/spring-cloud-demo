package com.github.yingzhuo.scd.consumer.controller;

import com.github.yingzhuo.scd.exception.BizException;
import com.github.yingzhuo.scd.exception.BizExceptionData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlers {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public BizExceptionData handle(BizException ex) {
        var data = new BizExceptionData();
        data.setCodeType(BizException.class.getSimpleName());
        data.setErrorMessage(ex.getMessage());
        return data;
    }

}
