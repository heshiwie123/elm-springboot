package com.elm.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.domin.dto.CartResponseDto;
import com.elm.domin.dto.ListCartDto;
import com.elm.domin.pojo.Business;
import com.elm.mapper.BusinessMapper;
import com.elm.mapper.CartMapper;
import com.elm.domin.pojo.Cart;
import com.elm.mapper.FoodMapper;
import com.elm.service.CartService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class CartServiceImpl extends ServiceImpl<CartMapper,Cart> implements CartService{
    @Resource
    private CartMapper cartMapper;
    @Resource
    private FoodMapper foodMapper;
    @Resource
    private BusinessMapper businessMapper;


    @Override
    public List<CartResponseDto> listCart(ListCartDto listCartDto) {
        List<Cart> cartList;
        if(listCartDto.getBusinessId()!=null){
            cartList= cartMapper.listCart(listCartDto.getUserId(),listCartDto.getBusinessId());
        }else {
            cartList= cartMapper.listCart(listCartDto.getUserId(),null);
        }

        log.info("cartList:=========>{}",cartList);
        List<CartResponseDto> cartResponseDtos=new ArrayList<>(cartList.size());

            for(Cart cart:cartList){
                log.info("cart:====================>{}",cart);
                CartResponseDto cartResponseDto=new CartResponseDto();

                cartResponseDto.setCartId(cart.getCartId());
                cartResponseDto.setQuantity(cart.getQuantity());
                cartResponseDto.setBusinessId(cart.getBusinessId());
                cartResponseDto.setCartId(cart.getCartId());
                cartResponseDto.setFoodId(cart.getFoodId());
                cartResponseDto.setFood(foodMapper.selectById(cart.getFoodId()));
                cartResponseDto.setBusiness(businessMapper.selectById(cart.getBusinessId()));
                cartResponseDtos.add(cartResponseDto);

            }

        return cartResponseDtos;
    }

    @Override
    public int saveCart(Cart cart) {
        //直接保存，需要有所需要素
        log.info("saveCart:======================>{}",cart);
       cartMapper.insert(cart);
       return cart.getCartId();
    }

    @Override
    public int updateCart(Cart cart) {
        LambdaUpdateWrapper<Cart> updateWrapper = new LambdaUpdateWrapper<Cart>();
        //先筛选，再更新
        //根据cartId
        log.info("updateCart:======================{}",cart);
        updateWrapper.eq(Cart::getUserId,cart.getUserId());
        updateWrapper.eq(Cart::getFoodId,cart.getFoodId());
        updateWrapper.eq(Cart::getBusinessId,cart.getBusinessId());
        updateWrapper.set(true,Cart::getQuantity,cart.getQuantity());
        cartMapper.update(cart,updateWrapper);
        return cart.getCartId();
    }

    @Override
    public int removeCart(Integer cartId) {
        log.info("removeCart:cartId======================{}",cartId);
        LambdaUpdateWrapper<Cart> updateWrapper = new LambdaUpdateWrapper<Cart>();
        updateWrapper.eq(Cart::getCartId,cartId);
        return cartMapper.delete(updateWrapper);
    }
}
