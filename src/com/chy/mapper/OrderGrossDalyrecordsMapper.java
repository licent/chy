package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.OrderGrossDalyrecords;

public interface OrderGrossDalyrecordsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(OrderGrossDalyrecords record);

	int insertSelective(OrderGrossDalyrecords record);

	OrderGrossDalyrecords selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderGrossDalyrecords record);

	int updateByPrimaryKey(OrderGrossDalyrecords record);

	int copyCustomerGross(Map<String, Object> pararms);

	int copyAutoPointGross(Map<String, Object> pararms);

	int copyFactoryGross(Map<String, Object> pararms);
	
	int copyAutoPointBrokerage(Map<String, Object> pararms);
	
	List<OrderGrossDalyrecords> selectUserDalyGrossByParams(Map<String, Object> params);
	
	int updateStatusByUserIdAndTime(Map<String, Object> params);
	
	Map<String,Object> queryUserGrossByUserId(Map<String,Object> params);
	
}