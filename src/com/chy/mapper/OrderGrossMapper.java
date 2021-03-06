package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.OrderGross;

public interface OrderGrossMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(OrderGross record);

	int insertSelective(OrderGross record);

	OrderGross selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderGross record);

	int updateByPrimaryKey(OrderGross record);

	int insertBatch(List<OrderGrossEx> records);

	List<OrderGross> selectUserGrossByParams(Map<String, Object> params);
	
	List<OrderGross> selectAutoPointBrokeAgeByParams(Map<String, Object> params);
	
}