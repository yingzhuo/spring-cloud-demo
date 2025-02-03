package com.github.yingzhuo.scd.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BizExceptionData implements Serializable {

    private String codeType;
    private String errorMessage;

}
