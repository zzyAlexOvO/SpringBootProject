package com.utakata.dataobject;

import com.utakata.enums.OrderStatusEnum;
import com.utakata.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Utakata
 * 2022/10/18 22:24
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /** 订单ID */
    @Id
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家OpenID */
    private String buyerOpenid;

    /** 订单总价 */
    private BigDecimal orderAmount;

    /** 订单状态，默认为新订单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
