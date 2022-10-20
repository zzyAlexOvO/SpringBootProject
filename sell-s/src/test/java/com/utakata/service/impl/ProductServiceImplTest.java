package com.utakata.service.impl;

import com.utakata.dataobject.ProductInfo;
import com.utakata.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Utakata
 * 2022/10/18 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("1234");
        Assert.assertNotEquals("12345",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345");
        productInfo.setProductName("菲力牛排");
        productInfo.setProductPrice(new BigDecimal(189.5));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("很牛逼的牛排");
        productInfo.setProductIcon("http://5574.jpg");
        productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
        productInfo.setCategoryType(20);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}