package com.chy.mapper;

import com.chy.pojo.out.Budan;

public interface BudanMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Budan record);

	int insertSelective(Budan record);

	Budan selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Budan record);

	int updateByPrimaryKey(Budan record);
}