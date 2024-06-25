package com.elm.domin.dto;

import com.elm.domin.pojo.Food;
import lombok.Data;

@Data
public class OrderdetailetDto {
    private Integer odId;
    private Integer orderId;
    private Integer quantity;

    private Food food;
}
