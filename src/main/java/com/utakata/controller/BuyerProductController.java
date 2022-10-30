package com.utakata.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.utakata.VO.ProductInfoVO;
import com.utakata.VO.ProductVo;
import com.utakata.VO.ResultVo;
import com.utakata.dataobject.ProductCategory;
import com.utakata.dataobject.ProductInfo;
import com.utakata.service.CatetGoryService;
import com.utakata.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Utakata
 * 2022/10/18 17:33
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CatetGoryService catetGoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
        //foreach方法
//        for (ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //lambda表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        catetGoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductCategory> productCategoryList = catetGoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVo> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategorytype(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);//spring提供，把一个对象的值copy到另外一个对象，取代传统set方法简约代码，逗号前copy到逗号后
                    productInfoVOList.add(productInfoVO);
                }
            }
           productVo.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVo);
        }

        ResultVo resultVo = new ResultVo();

        System.out.println(productVOList.size());
        resultVo.setData(productVOList);
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        return  resultVo;
    }

}
