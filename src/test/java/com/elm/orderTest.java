package com.elm;

import com.elm.controller.OrdersController;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.DeliveryAddress;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class orderTest {
    @Resource
    OrdersController ordersController;

    /**
     * listOrdersByUserId根据用户id获取订单列表
     */
    @Test
    public void test2() throws Exception {
        Integer userId=5;

        ResponseResult responseResult = ordersController.listOrdersByUserId(userId);
        System.out.println(responseResult);
    }

}
