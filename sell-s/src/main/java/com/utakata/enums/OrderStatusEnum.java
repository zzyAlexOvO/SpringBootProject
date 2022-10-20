package com.utakata.enums;

import lombok.Getter;

/**
 * Created by Utakata
 * 2022/10/18 22:31
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完成"),
    CANCEL(2,"订单取消");

    private  Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
