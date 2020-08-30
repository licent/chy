package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.ItemCats;

public interface ItemCatsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ItemCats record);

	int insertSelective(ItemCats record);

	ItemCats selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ItemCats record);

	int updateByPrimaryKey(ItemCats record);

	List<ItemCats> selectAllByParams(Map<String, Object> params);

}