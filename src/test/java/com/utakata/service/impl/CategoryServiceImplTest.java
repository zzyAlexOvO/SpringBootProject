package com.utakata.service.impl;

import com.utakata.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Utakata
 * 2022/10/18 15:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl service;

    @Test
    public void findOne() throws Exception{
        ProductCategory productCategory = service.findOne(1);
        System.out.println(productCategory.getCategoryName());
    }

    @Test
    public void findAll() throws Exception{
        List<ProductCategory> productCategoryList = service.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
        System.out.println(productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList = service.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
        System.out.println(productCategoryList.size());
    }

    @Test
    public void save() throws Exception{
        ProductCategory productCategory = new ProductCategory("牛排",20);
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }
}