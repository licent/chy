package com.mapper;

import com.pojo.out.ItemCats;

public interface ItemCatsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemCats record);

    int insertSelective(ItemCats record);

    ItemCats selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemCats record);

    int updateByPrimaryKey(ItemCats record);
}