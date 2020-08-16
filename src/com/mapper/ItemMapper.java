package com.mapper;

import com.pojo.out.Item;
import com.pojo.out.ItemWithBLOBs;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemWithBLOBs record);

    int insertSelective(ItemWithBLOBs record);

    ItemWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ItemWithBLOBs record);

    int updateByPrimaryKey(Item record);
}