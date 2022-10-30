package com.utakata.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 * Created by Utakata
 * 2022/10/18 17:48
 */
@Data
public class ProductVo {

    @JsonProperty("name")//对象序列化后返回前端为name
    private String categoryName;

    @JsonProperty("type")//对象序列化后返回前端为type
    private Integer categorytype;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
