package com.github.yingzhuo.scd.exception;

import java.io.Serializable;

/**
 * 业务异常
 */
public class BizException extends RuntimeException implements Serializable {

    public BizException(String message) {
        super(message);
    }

}
