package com.service;

import java.util.Map;

import com.pojo.out.AutoPoint;

public interface AutoPointService {
	
	int deleteByPrimaryKey(Integer id);

	int insert(AutoPoint record);

	int insertSelective(AutoPoint record);

	AutoPoint selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AutoPoint record);

	int updateByPrimaryKey(AutoPoint record);
	
	double selectSaleVolumeById(Map<String, Object> params);

	long selectFansById(Map<String, Object> params);
}
