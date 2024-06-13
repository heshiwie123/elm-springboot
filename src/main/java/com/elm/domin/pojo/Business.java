package com.elm.domin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "business")
public class Business {
    @TableId(value = "businessId",type = IdType.AUTO)
    private Integer businessId;

    private String businessName;

    private String businessAddress;

    private String businessExplain;

    private String businessImg;

    private Integer orderTypeId;

    private double starPrice; //起送费

    private double deliveryPrice; //配送费

    private String remarks;
}
