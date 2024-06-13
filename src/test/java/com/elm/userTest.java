package com.elm;

import com.elm.controller.CartController;
import com.elm.controller.UserController;
import com.elm.domin.dto.ListCartDto;
import com.elm.domin.dto.ResponseResult;
import com.elm.domin.dto.UserRequestDto;
import com.elm.domin.pojo.Cart;
import com.elm.domin.pojo.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userTest {
    @Resource
    UserController userController;

    /**
     * getUserByPhoneByPass登录
     */
    @Test
    public void test1() throws Exception {
        UserRequestDto userRequestDto=new UserRequestDto();
        userRequestDto.setPhoneNum("19978066054");
        userRequestDto.setPassword("123");
        ResponseResult responseResult = userController.getUserByPhoneByPass(userRequestDto);
        System.out.println(responseResult);
    }
    /**
     * saveUser用户注册
     */
    @Test
    public void test2() throws Exception {
        User user = new User();
        user.setUserName("666");
        user.setPassword("1230");
        user.setPhoneNum("123456789456");
        user.setUserSex(1);
        ResponseResult responseResult = userController.saveUser(user);
        System.out.println(responseResult);
    }



}
