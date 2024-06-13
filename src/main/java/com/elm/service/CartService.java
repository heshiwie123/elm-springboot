package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.domin.dto.CartResponseDto;
import com.elm.domin.dto.ListCartDto;
import com.elm.domin.pojo.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {
    public List<CartResponseDto> listCart(ListCartDto listCartDto);
    public int saveCart(Cart cart);
    public int updateCart(Cart cart);
    public int removeCart(Integer cartId);

}
