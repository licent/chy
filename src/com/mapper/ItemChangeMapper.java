package com.mapper;

import com.pojo.out.ItemChange;

public interface ItemChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemChange record);

    int insertSelective(ItemChange record);

    ItemChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemChange record);

    int updateByPrimaryKey(ItemChange record);
}