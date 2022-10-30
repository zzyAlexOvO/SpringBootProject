package com.utakata.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Utakata
 * 2022/10/18 16:22
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private  String productId;
    /** 商品名字 */
    private String productName;
    /** 商品价格*/
    private BigDecimal productPrice;
    /** 商品库存*/
    private Integer productStock;
    /** 商品描述 */
    private  String productDescription;
    /** 商品图标 */
    private String productIcon;
    /** 商品状态，0正常1下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
}
