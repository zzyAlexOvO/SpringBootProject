package com.utakata.service.impl;

import com.utakata.dataobject.OrderDetail;
import com.utakata.dataobject.OrderMaster;
import com.utakata.dataobject.ProductInfo;
import com.utakata.dto.CartDTO;
import com.utakata.dto.OrderDTO;
import com.utakata.enums.OrderStatusEnum;
import com.utakata.enums.PayStatusEnum;
import com.utakata.enums.ResultEnum;
import com.utakata.repository.OrderDetailRepository;
import com.utakata.repository.OrderMasterRepository;
import com.utakata.service.OrderService;
import com.utakata.service.ProductService;
import com.utakata.exception.SellException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.utakata.utils.KeyUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Utakata
 * 2022/10/19 0:17
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /** 创建订单 */
    @Override
    @Transactional //异常不执行下面代码，进行回滚
    public OrderDTO crete(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);//总价默认为0
        //查询商品（数量，价格）
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null){//商品不存在抛出异常，提示商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算订单价格
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                        .add(orderAmount);//multiply为提供专为BigDecimal数据类型进行乘法的方法
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);//spring提供，把一个对象的值copy到另外一个对象，取代传统set方法简约代码，逗号前copy到逗号后
            orderDetailRepository.save(orderDetail);
        }

        //写入订单数据库（orderMaster,orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //减去库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                        new CartDTO(e.getProductId(),e.getProductQuantity())).
                            collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }
    /** 查询单个订单 */
    @Override
    public OrderDTO findOne(String OrderId) {
        return null;
    }
    /** 查询订单列表 */
    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }
    /** 取消订单 */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }
    /** 完成订单 */
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }
    /** 支付订单 */
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
