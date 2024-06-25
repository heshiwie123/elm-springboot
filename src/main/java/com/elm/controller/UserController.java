package com.elm.controller;

import com.elm.domin.dto.ResponseResult;
import com.elm.domin.dto.UserRequestDto;
import com.elm.domin.enums.AppHttpCodeEnum;
import com.elm.domin.pojo.User;
import com.elm.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "UserController")
public class UserController {

    @Resource
    private UserService userService;
    @PostMapping(value = "/login")
    public ResponseResult getUserByPhoneByPass(@RequestBody UserRequestDto userRequestDto) {
        Map<String,Object> userInfo = userService.getUserByPhoneByPass(userRequestDto);

        if(userInfo == null){
            return ResponseResult.errorResult(500,"用户名或密码错误");

        }else {
            return new ResponseResult(200,"登录成功",userInfo);
        }
    }

    @PostMapping("/getUserExistByPhone")
    public ResponseResult getUserExistByPhone(@Param("phoneNum") String phoneNum) throws Exception{
        int res=userService.getUserExistByPhone(phoneNum);
        if(res!=0){
            return new ResponseResult(200,"用户存在");
        }
        return new ResponseResult(202,"用户不存在");
    }

    @PutMapping("/saveUser")
    public ResponseResult saveUser(@RequestBody User user) throws Exception{
        int res= userService.saveUser(user);
        if(res!=0){
            return new ResponseResult(200,"保存成功");
        }
        return new ResponseResult(500,"保存失败");

    }

}
