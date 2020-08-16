package com.mapper;

import com.pojo.out.ItemCollect;

public interface ItemCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemCollect record);

    int insertSelective(ItemCollect record);

    ItemCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemCollect record);

    int updateByPrimaryKey(ItemCollect record);
}