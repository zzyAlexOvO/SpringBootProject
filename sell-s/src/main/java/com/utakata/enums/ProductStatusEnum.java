package com.utakata.enums;

/**
 * 商品状态
 * Created by Utakata
 * 2022/10/18 16:54
 */
public enum ProductStatusEnum {
    UP(0,"上架"),
    Down(1,"下架")
    ;
    private  Integer code;
    private String message;


    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
