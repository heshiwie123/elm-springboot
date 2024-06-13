package com.elm;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Scanner;

@Data
@SpringBootTest
public class BcryptTest {
    private PasswordEncoder passwordEncoder;
    @Test
    public void myBcryptTest(){
        //模拟输入的明文密码
        String plaintextPassword="123";
        //为PasswordEncoder注入BCryptPasswordEncoder
        setPasswordEncoder(new BCryptPasswordEncoder());
        System.out.println("你的明文密码："+plaintextPassword);
        //使用BCryptPasswordEncoder进行加密
        String ciphertextPassword1=passwordEncoder.encode(plaintextPassword);
        //输出结果
        System.out.println("加密后的密码："+ciphertextPassword1);
        String ciphertextPassword2=passwordEncoder.encode(plaintextPassword);
        //输出结果
        System.out.println("加密后的密码："+ciphertextPassword2);
        String ciphertextPassword3=passwordEncoder.encode(plaintextPassword);
        //输出结果
        System.out.println("加密后的密码："+ciphertextPassword3);
        System.out.println("加密后的密码长度："+ciphertextPassword1.length());

    }
}
