package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.domin.dto.UserRequestDto;
import com.elm.domin.pojo.User;

import java.util.Map;

public interface UserService extends IService<User> {
    public Map<String,Object> getUserByPhoneByPass(UserRequestDto userRequestDto);

    public int getUserExistByPhone(String phoneNum);

    public int saveUser(User user);
}
