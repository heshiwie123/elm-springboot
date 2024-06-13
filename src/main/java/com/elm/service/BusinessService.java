package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.domin.pojo.Business;

import java.util.List;

public interface BusinessService extends IService<Business> {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    public Business getBusinessById(Integer businessId);
}
