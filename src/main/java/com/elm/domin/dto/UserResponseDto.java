package com.elm.domin.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Integer userId;

    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;
    private String phoneNum;
    //@TableLogic可以设置逻辑删除
    private Integer state;
}
