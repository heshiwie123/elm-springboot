package com.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.domin.pojo.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    /**
     listBusinessByOrderTypeId
     */
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    /**
     getBusinessById
     */
    public Business getBusinessById(Integer businessId);
}
