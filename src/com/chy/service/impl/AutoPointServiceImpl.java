package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.AutoPointMapper;
import com.chy.pojo.out.AutoPoint;
import com.chy.service.AutoPointService;

/**
 * 
 * @自提点
 */
@Service
public class AutoPointServiceImpl implements AutoPointService {

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

	@Override
	public List<AutoPoint> selectNearlyInfo(Map<String, Object> params) {
		return autoPointMapper.selectNearlyInfo(params);
	}

	@Override
	public List<AutoPoint> selectListByParams(Map<String, Object> params) {
		return autoPointMapper.selectListByParams(params);
	}

	@Override
	public AutoPoint selectAutoPointByParams(Map<String, Object> params) {
		return autoPointMapper.selectAutoPointByParams(params);
	}
	@Override
	public long selectAutoPointListCount(Map<String,Object> params) {
		return autoPointMapper.selectAutoPointListCount(params);
	}
	@Override
	public List<AutoPoint> selectAutoPointList(Map<String,Object> params){
		return autoPointMapper.selectAutoPointList(params);
	}
	@Override
	public AutoPoint selectAutopointApply(Map<String,Object> params) {
		return autoPointMapper.selectAutopointApply(params);
	}

}
