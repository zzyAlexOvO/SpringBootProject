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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    /** 商品库存*/
    private Integer productStock;
    /** 商品描述 */
    private  String productDescription;
    /** 商品图标 */
    private String productIcon;
    /** 商品状态，0正常 1下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
}
