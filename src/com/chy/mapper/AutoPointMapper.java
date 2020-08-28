package com.chy.mapper;

import java.util.Map;

import com.chy.pojo.out.AutoPoint;

public interface AutoPointMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AutoPoint record);

	int insertSelective(AutoPoint record);

	AutoPoint selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AutoPoint record);

	int updateByPrimaryKey(AutoPoint record);

	double selectSaleVolumeById(Map<String, Object> params);

	long selectFansById(Map<String, Object> params);
}