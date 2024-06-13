package com.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.domin.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    /**
     listCart
     */
    public List<Cart> listCart(@Param("userId") Integer userId,@Param("businessId") Integer businessId);

    /**
     saveCart
     */
    public int saveCart(Cart cart);

    /**
     updateCart
     */
    public int updateCart(Cart cart);

    /**
     removeCart
     */
    public int removeCart(Cart cart);
}
