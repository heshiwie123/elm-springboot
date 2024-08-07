//package com.elm.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfiguration {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://127.0.0.1:5173","http://127.0.0.1:8080","https://judiciallearningapplication.hswweb.cn/") // 允许所有源访问，可以指定具体的源
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
//                        .allowedHeaders("*") // 允许所有请求头
//                        .allowCredentials(true) // 是否允许发送Cookie
//                        .maxAge(3600); // 预检请求的有效期，单位为秒
//            }
//        };
//    }
//}