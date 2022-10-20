package com.utakata.dto;

import lombok.Data;

/**
 * 购物车DTO
 * Created by Utakata
 * 2022/10/19 0:54
 */
@Data
public class CartDTO {

    /** 商品id*/
    private String productId;

    /** 商品数量*/
    private Integer productQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
