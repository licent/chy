package com.chy.service;

import com.chy.pojo.out.Factory;

public interface FactoryService {
	int deleteByPrimaryKey(Integer id);

	int insert(Factory record);

	int insertSelective(Factory record);

	Factory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Factory record);

	int updateByPrimaryKey(Factory record);
}
