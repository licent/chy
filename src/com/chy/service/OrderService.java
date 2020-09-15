package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.Order;
import com.chy.pojo.out.OrderItem;

public interface OrderService {
	int deleteByPrimaryKey(Integer id);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	Order creatOrder(Order order, List<OrderItem> orderItem, String itemList) throws Exception;
	
	List<Order> selectListByParams(Map<String,Object> params);
	
	List<Order> selectListByParamsPageing(Map<String,Object> params);
	
	List<Order> selectListByAutoPint(Map<String,Object> params);
	
	long selectListOrderPageCount(Map<String, Object> params);
	
	String wechatPay(Order order,String openId) throws Exception;
	
}
