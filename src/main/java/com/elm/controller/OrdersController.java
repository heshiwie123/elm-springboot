package com.elm.controller;

import com.elm.domin.dto.OrdersListDto;
import com.elm.domin.dto.OrdersResponseDto;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.Orders;
import com.elm.service.OrdersService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")

public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PutMapping("/createOrders")
    public ResponseResult createOrders(@RequestBody Orders orders) throws Exception{
        System.out.println("createOrders==========================>"+orders);
        int res= ordersService.createOrders(orders);
        Map<String,Integer> map=new HashMap<>();
        map.put("res",res);
        return new ResponseResult(200,map);
    }

    @GetMapping("/getOrdersById")
    public ResponseResult getOrdersById(Integer orderId) throws Exception{
        OrdersListDto ordersResponseDto= ordersService.getOrdersById(orderId);
        Map<String,Object> map=new HashMap<>();
        map.put("ordersResponseDto",ordersResponseDto);
        return new ResponseResult(200,map);
    }

    @GetMapping("/listOrdersByUserId")
    public ResponseResult listOrdersByUserId(@Param("userId") Integer userId) throws Exception{
        List<OrdersListDto> ordersListDtos=ordersService.listOrdersByUserId(userId);
        Map<String, Object> map=new HashMap<>();
        map.put("ordersListDtos",ordersListDtos);
        return new ResponseResult(200,map);
    }
}
