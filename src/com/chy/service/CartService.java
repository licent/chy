package com.chy.service;

import java.util.Map;

import com.chy.pojo.out.Cart;

public interface CartService {
	int deleteByPrimaryKey(Integer id);

	int insert(Cart record);

	int insertSelective(Cart record);

	Cart selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Cart record);

	int updateByPrimaryKey(Cart record);

	long selectCountByParams(Map<String, Object> params);
}
