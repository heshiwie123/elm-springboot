package com.elm.controller;

import com.elm.domin.dto.OrderdetailetDto;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.OrderDetailet;
import com.elm.service.OrderDetailetService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orderDetailet")
public class OrderDetailetController {
    @Resource
    private OrderDetailetService orderDetailetService;

    @PostMapping("/saveOrderDetailetBatch")
    public ResponseResult saveOrderDetailetBatch( @RequestBody List<OrderDetailet> list){
        Boolean b = orderDetailetService.saveOrderDetailetBatch(list);
        if(b) return ResponseResult.okResult(200,"成功！");

        return ResponseResult.errorResult(500,"失败！");
    }
    @GetMapping("/listOrderDetailetByOrderId")
    public ResponseResult listOrderDetailetByOrderId(@Param("orderId") Integer orderId){
        List<OrderdetailetDto> orderDetailets = orderDetailetService.listOrderDetailetByOrderId(orderId);
        return ResponseResult.okResult(orderDetailets);
    }
}
