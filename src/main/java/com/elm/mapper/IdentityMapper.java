package com.elm.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.domin.pojo.Identity;
import com.elm.domin.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface IdentityMapper extends BaseMapper<Identity> {
    Set<Menu> selectMenuByIdentityIdS(@Param("Ids") Set<Integer> setId);
}
