package com.elm.domin.dto;

import com.elm.domin.pojo.Business;
import com.elm.domin.pojo.Cart;
import com.elm.domin.pojo.Food;
import lombok.Data;

@Data
public class CartResponseDto {
    private Integer cartId;
    private Integer foodId;
    private Integer businessId;
    private String userId;
    private Integer quantity;
    private Food food;
    private Business business;
}
