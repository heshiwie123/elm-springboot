package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.mapper.FoodMapper;
import com.elm.domin.pojo.Food;
import com.elm.service.FoodService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        log.info("listFoodByBusinessId:businessId===================>{}",businessId);
        LambdaQueryWrapper<Food> queryWrapper = new LambdaQueryWrapper<Food>();
        queryWrapper.eq(Food::getBusinessId,businessId);
        List<Food> foodList= foodMapper.selectList(queryWrapper);
        return foodList;
    }
}
