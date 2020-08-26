package com.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.AutoPointMapper;
import com.pojo.out.AutoPoint;
import com.service.AutoPointService;

/**
 * 
 * @自提点
 */
@Service
public class AutoPointServiceImpl implements AutoPointService{
	
	@Autowired
	AutoPointMapper autoPointMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return autoPointMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AutoPoint record) {
		return autoPointMapper.insert(record);
	}

	@Override
	public int insertSelective(AutoPoint record) {
		return autoPointMapper.insertSelective(record);
	}

	@Override
	public AutoPoint selectByPrimaryKey(Integer id) {
		return autoPointMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AutoPoint record) {
		return autoPointMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AutoPoint record) {
		return autoPointMapper.updateByPrimaryKey(record);
	}

	@Override
	public double selectSaleVolumeById(Map<String, Object> params) {
		return autoPointMapper.selectSaleVolumeById(params);
	}

	@Override
	public long selectFansById(Map<String, Object> params) {
		return autoPointMapper.selectFansById(params);
	}

}
