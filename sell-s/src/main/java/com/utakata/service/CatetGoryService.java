package com.utakata.service;

import com.utakata.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Utakata
 * 2022/10/18 15:40
 */
public interface CatetGoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
