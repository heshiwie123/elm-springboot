package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.mapper.BusinessMapper;
import com.elm.domin.pojo.Business;
import com.elm.service.BusinessService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@Slf4j
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {
    @Resource
    BusinessMapper businessMapper;



    /**
     listBusinessByOrderTypeId
     */
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        log.info("listBusinessByOrderTypeId:orderTypeId：=============================》{}",orderTypeId);
        LambdaQueryWrapper<Business> queryWrapper=new LambdaQueryWrapper<Business>();
        queryWrapper.eq(Business::getOrderTypeId,orderTypeId);
        List<Business> businesses= businessMapper.selectList(queryWrapper);
        return businesses;
    }

    /**
     getBusinessById
     */
    @Override
    public Business getBusinessById(Integer businessId) {
        log.info("getBusinessById:businessId：=============================》{}",businessId);
        LambdaQueryWrapper<Business> queryWrapper=new LambdaQueryWrapper<Business>();
        queryWrapper.eq(Business::getBusinessId,businessId);
        Business business= businessMapper.selectOne(queryWrapper);
        return business;
    }
}
