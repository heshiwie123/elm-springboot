package com.elm;

import com.elm.domin.pojo.User;
import com.elm.service.BusinessService;
import com.elm.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.plaf.PanelUI;

@SpringBootTest
public class Test22 {
    @Autowired
    BusinessService businessService;

    @Resource
    UserService userService;

    User user=new User();
    @Test
    public void test7(){

        user.setUserSex(0);
        user.setPassword("123");
        user.setUserName("546");
        user.setUserImg("45646");
        user.setDelTag(0);
        System.out.println(userService.saveUser(user));
    }
    @Test
    public void testBcrypt(){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        System.out.println("123:"+encoder.encode("123"));
        //密文验证测试
        System.out.println(encoder.matches("123","$2a$10$EQsv4yVH8Ks9AiSDBUHykerNFqomrk26jqDlObP3PAdO8er9W.6Xy"));
    }
}
