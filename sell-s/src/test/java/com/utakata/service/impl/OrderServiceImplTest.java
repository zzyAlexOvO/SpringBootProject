package com.utakata.service.impl;

import com.utakata.dataobject.OrderDetail;
import com.utakata.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Utakata
 * 2022/10/19 1:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void crete() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("鸡丁");
        orderDTO.setBuyerOpenid("007");
        orderDTO.setBuyerPhone("110");
        orderDTO.setBuyerAddress("太平洋");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1234");
        orderDetail.setProductQuantity(10);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("12345");
        orderDetail2.setProductQuantity(10);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail2);


        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.crete(orderDTO);
        log.info("[创建订单] result{}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}