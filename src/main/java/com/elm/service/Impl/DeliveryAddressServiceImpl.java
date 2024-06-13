package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.mapper.DeliveryAddressMapper;
import com.elm.domin.pojo.DeliveryAddress;
import com.elm.service.DeliveryAddressService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress>implements DeliveryAddressService {
    @Resource
    DeliveryAddressMapper deliveryAddressMapper;
    LambdaQueryWrapper<DeliveryAddress> queryWrapper = new LambdaQueryWrapper<DeliveryAddress>();
    LambdaUpdateWrapper<DeliveryAddress> updateWrapper = new LambdaUpdateWrapper<DeliveryAddress>();
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(Integer userId) {
        log.info("listDeliveryAddressByUserId:userId====================>{}",userId);
       queryWrapper.eq(DeliveryAddress::getUserId,userId);
        List<DeliveryAddress> deliveryAddresses= deliveryAddressMapper.selectList(queryWrapper);
        queryWrapper.clear();
        return deliveryAddresses;
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        log.info("getDeliveryAddressById:daId====================>{}",daId);
        queryWrapper.eq(DeliveryAddress::getDaId,daId);
        DeliveryAddress deliveryAddress= deliveryAddressMapper.selectOne(queryWrapper);
        log.info("deliveryAddress:==========================>{}",deliveryAddress);
        queryWrapper.clear();
        return deliveryAddress;
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        log.info("saveDeliveryAddress:deliveryAddress====================>{}",deliveryAddress);
        return deliveryAddressMapper.insert(deliveryAddress);
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        updateWrapper.clear();
        log.info("updateDeliveryAddress:deliveryAddress====================>{}",deliveryAddress);
        updateWrapper.eq(DeliveryAddress::getDaId,deliveryAddress.getDaId());
        int res= deliveryAddressMapper.update(deliveryAddress,updateWrapper);
        updateWrapper.clear();
        return res;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        log.info("removeDeliveryAddress:daId====================>{}",daId);
        return deliveryAddressMapper.deleteById(daId);
    }
}
