package com.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.elm.domin.pojo.DeliveryAddress;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {

    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);


    public DeliveryAddress getDeliveryAddressById(Integer daId);


    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    public int removeDeliveryAddress(Integer daId);
}
