package com.elm.controller;

import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.Business;
import com.elm.service.BusinessService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/business")

public class BusinessController {

    @Resource
    private BusinessService businessService;

    @GetMapping(value = "/listBusinessByOrderTypeId")
    public ResponseResult listBusinessByOrderTypeId(@Param("orderTypeId") Integer orderTypeId) throws Exception{
        List<Business> businesses= businessService.listBusinessByOrderTypeId(orderTypeId);
        Map<String, List<Business>> map=new HashMap<>();
        map.put("businessList",businesses);
        return new ResponseResult(200,map);
    }

    @GetMapping("/getBusinessById")
    public ResponseResult getBusinessById(@Param("businessId") Integer businessId) throws Exception{
        Business business= businessService.getBusinessById(businessId);
        Map<String,Object> map=new HashMap<>();
        map.put("business",business);
        return new ResponseResult(200,"查询成功",map);
    }
}