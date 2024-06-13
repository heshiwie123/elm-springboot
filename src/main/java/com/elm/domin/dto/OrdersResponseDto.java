package com.elm.domin.dto;

import com.elm.domin.pojo.Business;
import lombok.Data;

import java.util.Date;
@Data
public class OrdersResponseDto {
    private Integer orderId;
    private Integer userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState; //订单状态（0：未支付； 1：已支付）
    private Business business;
}
