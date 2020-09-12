package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.OrderGrossMapper;
import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.OrderGross;
import com.chy.service.OrderGrossService;

/**
 * @毛利记录表
 */
@Service
public class OrderGrossServiceImpl implements OrderGrossService {

	@Autowired
	OrderGrossMapper orderGrossMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return orderGrossMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrderGross record) {
		return orderGrossMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderGross record) {
		return orderGrossMapper.insertSelective(record);
	}

	@Override
	public OrderGross selectByPrimaryKey(Integer id) {
		return orderGrossMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderGross record) {
		return orderGrossMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderGross record) {
		return orderGrossMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertBatch(List<OrderGrossEx> records) {
		return orderGrossMapper.insertBatch(records);
	}

	@Override
	public List<OrderGross> selectUserGrossByParams(Map<String, Object> params) {
		return orderGrossMapper.selectUserGrossByParams(params);
	}

	@Override
	public List<OrderGross> selectAutoPointBrokeAgeByParams(Map<String, Object> params) {
		return orderGrossMapper.selectAutoPointBrokeAgeByParams(params);
	}

}
