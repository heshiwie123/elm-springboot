package com.elm.domin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "deliveryAddress")
public class DeliveryAddress {
    @TableId(value = "daId",type = IdType.AUTO)
    private Integer daId;
    private String contactName;
    private Integer contactSex;
    private String contactTel;
    private String address;
    private Integer userId;
}
