package com.elm;


import com.elm.controller.FoodController;
import com.elm.domin.dto.ResponseResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class foodTest {
    //使用@Resource而不是直接new对象，否则spring认为不需要管理
    //不会自动引入FoodController中的FoodService
    @Resource
    FoodController foodController;

    /**
     * listFoodByBusiness根据商家id获取食物列表
     */
    @Test
    public void test1() throws Exception {
        Integer businessId=10001;
        ResponseResult responseResult=foodController.listFoodByBusinessId(businessId);
        System.out.println(responseResult);
    }

}
