package com.chy.mapper;

import com.chy.pojo.out.ItemSku;

public interface ItemSkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemSku record);

    int insertSelective(ItemSku record);

    ItemSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemSku record);

    int updateByPrimaryKey(ItemSku record);
}