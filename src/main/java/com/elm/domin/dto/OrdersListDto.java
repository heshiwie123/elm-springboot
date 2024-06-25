package com.elm.domin.dto;

import com.elm.domin.pojo.Business;
import com.elm.domin.pojo.Food;
import com.elm.domin.pojo.OrderDetailet;
import lombok.Data;

import java.util.List;
@Data
public class OrdersListDto {


    private Double orderTotal;

    private Integer orderState; //订单状态（0：未支付； 1：已支付）
    private  Business business;
    private List<OrderdetailetDto> list;
}
