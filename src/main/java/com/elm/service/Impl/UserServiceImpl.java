package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.domin.dto.UserRequestDto;
import com.elm.domin.dto.UserResponseDto;
import com.elm.mapper.UserMapper;

import com.elm.domin.pojo.User;
import com.elm.service.UserService;
import com.elm.utils.JwtUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    UserMapper userMapper;
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();

    @Override
    public Map<String,Object> getUserByPhoneByPass(UserRequestDto userRequestDto) {
        //传入用户名，密码
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userRequestDto.getPhoneNum(), userRequestDto.getPassword());
        //实现登录逻辑,会去调用在UserDetails里定义的loadUserByUsername
        //authenticate就是UserDetails
        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(authentication);
        } catch (RuntimeException e) {
            e.printStackTrace();
            log.info("用户名或者密码错误!");
            return null;
        }
        //获取返回的用户
        User user =  new User();
        user = (User) authenticate.getPrincipal();
        log.info("登录后的用户=======》{}", user);
        if (user == null) {
            return null;
        }
        //根据用户信息生成token
        Map<String, Object> tokenmap = new HashMap<>();
        tokenmap.put("用户Id", user.getUserId());
        tokenmap.put("用户Name", user.getUsername());
        tokenmap.put("用户身份", user.getIdentitySet());
        tokenmap.put("用户权限", user.getMenus());


        //存储用户token信息的map
        Map<String,Object> userMap=new HashMap<>();
        log.info("用户map==============================={}",tokenmap);
        //返回体，初始化
        UserResponseDto userResponseDto=new UserResponseDto();
        //获取并存储用户个人信息
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUserName(user.getUsername());
        userResponseDto.setUserImg(user.getUserImg());
        userResponseDto.setUserSex(user.getUserSex());

        userResponseDto.setPhoneNum(user.getPhoneNum());
        userResponseDto.setState(user.getState());

        userMap.put("userInfo",userResponseDto);
        //存储token

        userMap.put("token", JwtUtils.creatToken(tokenmap));
        log.info("token:======================>{}",JwtUtils.creatToken(tokenmap));
        return userMap;
    }

    @Override
    public int getUserExistByPhone(String phoneNum) {
        log.info("getUserById:phoneNum==================>{}", phoneNum);
        queryWrapper.eq(User::getPhoneNum, phoneNum);
        queryWrapper.select(User::getUserId);
        int res = userMapper.selectList(queryWrapper).size();
        log.info("getUserById:res==================>{}", res);
        //queryWrapper晴空，否则会queryWrapper留存在内存中，出现 WHERE (userId = ? AND userId = ? AND userId = ?)
        queryWrapper.clear();
        return res;
    }

    @Override
    public int saveUser(User user) {
        log.info("getUserById:user==================>{}", user);
        //加密为密文
        String password=encoder.encode(user.getPassword());
        user.setPassword(password);
        int res = userMapper.insert(user);
        log.info("getUserById:res==================>{}", res);
        //这里根据用户号码，给用户添加默认的普通用户身份
        userMapper.userDefaultIdentity(user.getPhoneNum());
        queryWrapper.clear();
        return res;
    }
}
