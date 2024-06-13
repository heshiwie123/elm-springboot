package com.elm.controller;

import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.Food;
import com.elm.service.FoodService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;
    @GetMapping("/listFoodByBusinessId")
    public ResponseResult listFoodByBusinessId(@Param("businessId") Integer businessId) throws Exception{
        List<Food> foodList= foodService.listFoodByBusinessId(businessId);
        Map<String,Object> map=new HashMap<>();
        map.put("foodList",foodList);
        return new ResponseResult(200,"查询成功",map);
    }
}