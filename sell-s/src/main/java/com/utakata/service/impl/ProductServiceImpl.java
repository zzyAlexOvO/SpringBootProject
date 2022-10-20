package com.utakata.service.impl;

import com.utakata.dataobject.ProductInfo;
import com.utakata.dto.CartDTO;
import com.utakata.enums.ProductStatusEnum;
import com.utakata.enums.ResultEnum;
import com.utakata.repository.ProductInfoRepository;
import com.utakata.service.ProductService;
import com.utakata.exception.SellException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Utakata
 * 2022/10/18 16:52
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository repository;
    /**
     * 通过ID查询某一条商品
     * Created by Utakata
     * 2022/10/18 17:01
     */
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    /**
     * 查询上架商品
     * Created by Utakata
     * 2022/10/18 17:01
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 分页查询所有商品
     * Created by Utakata
     * 2022/10/18 17:01
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * 增加、修改商品
     * Created by Utakata
     * 2022/10/18 17:01
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    /**
     * 加库存
     * Created by Utakata
     * 2022/10/19 1:05
     */
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    /**
     * 减库存
     * Created by Utakata
     * 2022/10/19 1:05
     */
    @Override
    @Transactional//异常不执行下面代码，进行回滚
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
           ProductInfo productInfo =  repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if (result < 0){//判断库存是否足够不够则抛出异常
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
