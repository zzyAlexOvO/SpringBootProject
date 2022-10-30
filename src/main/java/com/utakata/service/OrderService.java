package com.utakata.service;

import com.utakata.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Utakata
 * 2022/10/19 0:08
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO crete(OrderDTO orderDto);
    /** 查询单个订单 */
    OrderDTO findOne(String OrderId);
    /** 查询订单列表 */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);
    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完成订单 */
    OrderDTO finish(OrderDTO orderDTO);
    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
