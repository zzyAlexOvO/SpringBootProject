package com.utakata.enums;

import lombok.Getter;

/**
 * Created by Utakata
 * 2022/10/19 0:24
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(20,"库存不正确");
    private  Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
