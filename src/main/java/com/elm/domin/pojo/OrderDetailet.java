package com.elm.domin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "orderdetailet")
public class OrderDetailet {
    @TableId(value = "odId",type = IdType.AUTO)
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
}
