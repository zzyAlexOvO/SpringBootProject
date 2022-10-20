package com.utakata.exception;

import com.utakata.enums.ResultEnum;

/**
 * Created by Utakata
 * 2022/10/19 0:23
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
