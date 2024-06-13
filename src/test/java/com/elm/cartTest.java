package com.elm;

import com.elm.controller.CartController;
import com.elm.domin.dto.ListCartDto;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.pojo.Cart;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class cartTest {
    @Resource
    CartController cartController;

    /**
     * saveCart保存购物车
     */
    @Test
    public void test1() throws Exception {
        Cart cart = new Cart();
        cart.setUserId(5);
        cart.setFoodId(5);
        cart.setBusinessId(10001);
        cart.setQuantity(5);
        ResponseResult responseResult = cartController.saveCart(cart);
        System.out.println(responseResult);
    }
    /**
     * updateCart更新购物车的信息
     */
    @Test
    public void test2() throws Exception {
        Cart cart = new Cart();
        cart.setUserId(5);
        cart.setFoodId(2);
        cart.setBusinessId(10001);
        cart.setQuantity(5);
        ResponseResult responseResult = cartController.updateCart(cart);
        System.out.println(responseResult);
    }
    /**
     * listCart，获取用户购物车列表
     */
    @Test
    public void test3() throws Exception {
        ListCartDto listCartDto=new ListCartDto();
        listCartDto.setUserId(5);
        ResponseResult responseResult = cartController.listCart(listCartDto);
        System.out.println(responseResult);
    }
}
