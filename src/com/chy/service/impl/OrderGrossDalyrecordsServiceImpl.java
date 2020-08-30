package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.OrderGrossDalyrecordsMapper;
import com.chy.pojo.out.OrderGrossDalyrecords;
import com.chy.service.OrderGrossDalyrecordsService;

/**
 * @毛利分红服务
 */
@Service
public class OrderGrossDalyrecordsServiceImpl implements OrderGrossDalyrecordsService {

	@Autowired
	OrderGrossDalyrecordsMapper orderGrossDalyrecordsMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return orderGrossDalyrecordsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrderGrossDalyrecords record) {
		return orderGrossDalyrecordsMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderGrossDalyrecords record) {
		return orderGrossDalyrecordsMapper.insertSelective(record);
	}

	@Override
	public OrderGrossDalyrecords selectByPrimaryKey(Integer id) {
		return orderGrossDalyrecordsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderGrossDalyrecords record) {
		return orderGrossDalyrecordsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderGrossDalyrecords record) {
		return orderGrossDalyrecordsMapper.updateByPrimaryKey(record);
	}

	@Override
	public int copyCustomerGross(Map<String, Object> pararms) {
		return orderGrossDalyrecordsMapper.copyCustomerGross(pararms);
	}

	@Override
	public int copyAutoPointGross(Map<String, Object> pararms) {
		return orderGrossDalyrecordsMapper.copyAutoPointGross(pararms);
	}

	@Override
	public int copyFactoryGross(Map<String, Object> pararms) {
		return orderGrossDalyrecordsMapper.copyFactoryGross(pararms);
	}

	@Override
	public List<OrderGrossDalyrecords> selectUserDalyGrossByParams(Map<String, Object> params) {
		return orderGrossDalyrecordsMapper.selectUserDalyGrossByParams(params);
	}

	@Override
	public int updateStatusByUserIdAndTime(Map<String, Object> params) {
		return orderGrossDalyrecordsMapper.updateStatusByUserIdAndTime(params);
	}

}
