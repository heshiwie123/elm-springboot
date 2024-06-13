package com.elm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.domin.dto.OrdersListDto;
import com.elm.domin.dto.OrdersResponseDto;
import com.elm.domin.pojo.Orders;

import java.util.List;

public interface OrdersService extends IService<Orders> {
    public int createOrders(Orders orders);

    public OrdersResponseDto getOrdersById(Integer orderId);

    public List<OrdersListDto> listOrdersByUserId(Integer userId);
}
