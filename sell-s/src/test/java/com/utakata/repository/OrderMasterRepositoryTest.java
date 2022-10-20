package com.utakata.repository;

import com.utakata.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Utakata
 * 2022/10/18 22:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="007";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1111");
        orderMaster.setBuyerName("鸡丁");
        orderMaster.setOrderAmount(new BigDecimal(298));
        orderMaster.setBuyerAddress("太平洋");
        orderMaster.setBuyerPhone("110");
        orderMaster.setBuyerOpenid("007");

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenId() {
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> page = repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,page.getTotalElements());
        System.out.println(page.getTotalElements());
    }
}