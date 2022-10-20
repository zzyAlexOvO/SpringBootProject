package com.utakata.service.impl;

import com.utakata.dataobject.ProductCategory;
import com.utakata.repository.ProductCategoryRepository;
import com.utakata.service.CatetGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by Utakata
 * 2022/10/18 15:42
 */
@Service
public class CategoryServiceImpl implements CatetGoryService {
    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 通过ID查询某一条类目
     * Created by Utakata
     * 2022/10/18 16:18
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    /**
     * 查询所有类目
     * Created by Utakata
     * 2022/10/18 16:18
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    /**
     * 通过type查询类目
     * Created by Utakata
     * 2022/10/18 16:18
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    /**
     * 新增、更新类目
     * Created by Utakata
     * 2022/10/18 16:18
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
