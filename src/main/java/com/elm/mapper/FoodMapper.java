package com.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.domin.pojo.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {

    public List<Food> listFoodByBusinessId(Integer businessId);


    public Food getFoodById(Integer foodId);
}
