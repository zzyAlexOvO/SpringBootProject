package com.utakata.repository;

import com.utakata.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Utakata
 * 2022/10/18 23:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository repository;
    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("66666");
        orderDetail.setOrderId("1111166");
        orderDetail.setProductIcon("http://ss.jpg");
        orderDetail.setProductName("牛排");
        orderDetail.setProductPrice(new BigDecimal(55));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductId("255");
        OrderDetail orderDetail1 = repository.save(orderDetail);
        Assert.assertNotNull(orderDetail1);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetails = repository.findByOrderId("11111");
        Assert.assertNotEquals(0,orderDetails.size());
    }
}