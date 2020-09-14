package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.Factory;

public interface FactoryService {
	int deleteByPrimaryKey(Integer id);

	int insert(Factory record);

	int insertSelective(Factory record);

	Factory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Factory record);

	int updateByPrimaryKey(Factory record);
	
	List<Factory> selectFactoryList(Map<String, Object> params);
	
	long selectFactoryListCount(Map<String,Object> params);
}
