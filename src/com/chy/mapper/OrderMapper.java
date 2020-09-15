package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
	List<Order> selectListByParams(Map<String,Object> params);
	
	List<Order> selectListByParamsPageing(Map<String,Object> params);
	
	List<Order> selectListByAutoPint(Map<String,Object> params);
	
	long selectListOrderPageCount(Map<String, Object> params);
	
	int updateStatusByOrderCode(Order record);
}