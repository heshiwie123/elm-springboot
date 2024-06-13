package com.elm;

import com.elm.controller.DeliveryAddressController;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.dto.UserRequestDto;
import com.elm.domin.pojo.DeliveryAddress;
import com.elm.domin.pojo.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeliveryAddressTest {
    @Resource
    DeliveryAddressController deliveryAddressController;
    /**
     * listDeliveryAddressByUserId根据用户id获取地址列表
     */
    @Test
    public void test1() throws Exception {
        Integer userId=5;
        ResponseResult responseResult = deliveryAddressController.listDeliveryAddressByUserId(userId);
        System.out.println(responseResult);
    }
    /**
     * saveDeliveryAddress保存地址
     */
    @Test
    public void test2() throws Exception {
        DeliveryAddress deliveryAddress=new DeliveryAddress();
        deliveryAddress.setAddress("云南大学");
        deliveryAddress.setContactSex(1);
        deliveryAddress.setUserId(5);
        deliveryAddress.setContactName("xiaomi");
        deliveryAddress.setContactTel("19978066054");

        ResponseResult responseResult = deliveryAddressController.saveDeliveryAddress(deliveryAddress);
        System.out.println(responseResult);
    }
    /**
     * updateDeliveryAddress更改地址
     */
    @Test
    public void test3() throws Exception {
        DeliveryAddress deliveryAddress=new DeliveryAddress();
        deliveryAddress.setAddress("云南大学11111");
        deliveryAddress.setContactSex(1);
        deliveryAddress.setUserId(5);
        deliveryAddress.setContactName("xiaomi");
        deliveryAddress.setContactTel("19978066054");
        deliveryAddress.setDaId(3);
        ResponseResult responseResult = deliveryAddressController.updateDeliveryAddress(deliveryAddress);
        System.out.println(responseResult);
    }
}
