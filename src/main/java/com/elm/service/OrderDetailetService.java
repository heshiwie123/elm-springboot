package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.domin.dto.OrderdetailetDto;
import com.elm.domin.pojo.OrderDetailet;

import java.util.List;

public interface OrderDetailetService extends IService<OrderDetailet> {
    public Boolean saveOrderDetailetBatch(List<OrderDetailet> list);

    public List<OrderdetailetDto> listOrderDetailetByOrderId(Integer orderId);
}
