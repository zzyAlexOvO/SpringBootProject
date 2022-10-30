package com.utakata.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Utakata
 * 2022/10/18 17:53
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")//对象序列化后返回前端为id
    private String productId;

    @JsonProperty("name")//对象序列化后返回前端为name
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
