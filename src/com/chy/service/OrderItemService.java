package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.OrderItem;

public interface OrderItemService {
	int deleteByPrimaryKey(Integer id);

	int insert(OrderItem record);

	int insertSelective(OrderItem record);

	OrderItem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	int insertBatch(List<OrderItem> records);
	
	int updateByParams(Map<String,Object> params);
}
