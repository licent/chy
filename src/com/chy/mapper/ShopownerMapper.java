package com.chy.mapper;

import com.chy.pojo.out.Shopowner;

public interface ShopownerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shopowner record);

    int insertSelective(Shopowner record);

    Shopowner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shopowner record);

    int updateByPrimaryKey(Shopowner record);
}