package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.domin.dto.OrdersListDto;
import com.elm.domin.dto.OrdersResponseDto;
import com.elm.mapper.BusinessMapper;
import com.elm.mapper.FoodMapper;
import com.elm.mapper.OrdersMapper;
import com.elm.domin.pojo.Orders;
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
    FoodMapper foodMapper;
    LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<Orders>();
    @Override
    public int createOrders(Orders orders) {

        save(orders);
        return orders.getOrderId();
    }

    @Override
    public OrdersResponseDto getOrdersById(Integer orderId) {
        OrdersResponseDto ordersResponseDto=new OrdersResponseDto();
       queryWrapper.eq(Orders::getOrderId,orderId);
       Orders orders= ordersMapper.selectOne(queryWrapper);
        ordersResponseDto.setOrderId(orders.getOrderId());
        ordersResponseDto.setOrderDate(orders.getOrderDate());
        ordersResponseDto.setOrderTotal(orders.getOrderTotal());
        ordersResponseDto.setOrderState(orders.getOrderState());
        ordersResponseDto.setDaId(orders.getDaId());
        ordersResponseDto.setUserId(orders.getUserId());
        ordersResponseDto.setBusinessId(orders.getBusinessId());

        ordersResponseDto.setBusiness(businessMapper.selectById(orders.getBusinessId()));

       queryWrapper.clear();
       return ordersResponseDto;
    }

    @Override
    public List<OrdersListDto> listOrdersByUserId(Integer userId) {
        List<OrdersListDto> ordersListDtos=new ArrayList<>();
        queryWrapper.eq(Orders::getUserId,userId);

        List<Orders> orders =  ordersMapper.selectList(queryWrapper);
        for(Orders order:orders){
            OrdersListDto ordersListDto=new OrdersListDto();
            ordersListDto.setOrderState(order.getOrderState());
            ordersListDto.setOrderTotal(order.getOrderTotal());
            ordersListDto.setBusiness(businessMapper.selectById(order.getBusinessId()));
            ordersListDtos.add(ordersListDto);
        }
        queryWrapper.clear();
        return ordersListDtos;
    }
}
