package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.OrderItemMapper;
import com.chy.pojo.out.OrderItem;
import com.chy.service.OrderItemService;

/**
 * @订单商品关联信息
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	OrderItemMapper orderItemMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return orderItemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrderItem record) {
		return orderItemMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderItem record) {
		return orderItemMapper.insertSelective(record);
	}

	@Override
	public OrderItem selectByPrimaryKey(Integer id) {
		return orderItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderItem record) {
		return orderItemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderItem record) {
		return orderItemMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertBatch(List<OrderItem> records) {
		return orderItemMapper.insertBatch(records);
	}

	@Override
	public int updateByParams(Map<String, Object> params) {
		return orderItemMapper.updateByParams(params);
	}

}
