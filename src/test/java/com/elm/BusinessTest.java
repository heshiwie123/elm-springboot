package com.elm;

import com.elm.controller.BusinessController;
import com.elm.domin.dto.ResponseResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BusinessTest {
    @Resource
    BusinessController businessController;

    /**
     * listBusinessByOrderTypeId根据食物类型选择商家列表信息
     */
    @Test
    public void test1() throws Exception {
        Integer orderTypeId=1;
        ResponseResult responseResult = businessController.listBusinessByOrderTypeId(orderTypeId);
        System.out.println(responseResult);
    }
}
