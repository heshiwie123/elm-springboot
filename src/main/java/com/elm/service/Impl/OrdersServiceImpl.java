package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.domin.dto.OrdersListDto;
import com.elm.domin.dto.OrdersResponseDto;
import com.elm.mapper.BusinessMapper;
import com.elm.mapper.FoodMapper;
import com.elm.mapper.OrdersMapper;
import com.elm.domin.pojo.Orders;
import com.elm.service.OrderDetailetService;
import com.elm.service.OrdersService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    BusinessMapper businessMapper;
    @Resource
    private OrderDetailetService orderDetailetService;
    @Resource
    FoodMapper foodMapper;

    @Override
    public int createOrders(Orders orders) {
        save(orders);
        return orders.getOrderId();
    }

    @Override
    public OrdersListDto getOrdersById(Integer orderId) {
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<Orders>();
        OrdersListDto ordersResponseDto=new OrdersListDto();
       queryWrapper.eq(Orders::getOrderId,orderId);
       Orders orders= ordersMapper.selectOne(queryWrapper);
        ordersResponseDto.setOrderTotal(orders.getOrderTotal());
        ordersResponseDto.setOrderState(orders.getOrderState());

        ordersResponseDto.setBusiness(businessMapper.selectById(orders.getBusinessId()));
        ordersResponseDto.setList(orderDetailetService.listOrderDetailetByOrderId(orderId));
       return ordersResponseDto;
    }

    @Override
    public List<OrdersListDto> listOrdersByUserId(Integer userId) {
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<Orders>();
        List<OrdersListDto> ordersListDtos=new ArrayList<>();
        queryWrapper.eq(Orders::getUserId,userId);

        List<Orders> orders =  ordersMapper.selectList(queryWrapper);
        for(Orders order:orders){
            OrdersListDto ordersListDto=new OrdersListDto();
            ordersListDto.setOrderState(order.getOrderState());
            ordersListDto.setOrderTotal(order.getOrderTotal());
            ordersListDto.setBusiness(businessMapper.selectById(order.getBusinessId()));
            ordersListDto.setList(orderDetailetService.listOrderDetailetByOrderId(order.getOrderId()));
            ordersListDtos.add(ordersListDto);
        }
        queryWrapper.clear();
        return ordersListDtos;
    }
}
