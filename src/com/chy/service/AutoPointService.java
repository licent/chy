package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.AutoPoint;

public interface AutoPointService {
	
	int deleteByPrimaryKey(Integer id);

	int insert(AutoPoint record);

	int insertSelective(AutoPoint record);

	AutoPoint selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AutoPoint record);

	int updateByPrimaryKey(AutoPoint record);
	
	double selectSaleVolumeById(Map<String, Object> params);

	long selectFansById(Map<String, Object> params);
	
	List<AutoPoint> selectNearlyInfo(Map<String, Object> params);
	
	List<AutoPoint> selectListByParams (Map<String, Object> params);
	
	AutoPoint selectAutoPointByParams(Map<String, Object> params);
	
	long selectAutoPointListCount(Map<String,Object> params);
	
	List<AutoPoint> selectAutoPointList(Map<String,Object> params);
	
	AutoPoint selectAutopointApply(Map<String,Object> params);
}
