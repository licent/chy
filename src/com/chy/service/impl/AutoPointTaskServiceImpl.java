package com.chy.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.AutoPointaskMapper;
import com.chy.pojo.out.AutoPointask;
import com.chy.service.AutoPointTaskService;

@Service
public class AutoPointTaskServiceImpl implements AutoPointTaskService{
	
	@Autowired
	AutoPointaskMapper autoPointaskMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return autoPointaskMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AutoPointask record) {
		return autoPointaskMapper.insert(record);
	}

	@Override
	public int insertSelective(AutoPointask record) {
		return autoPointaskMapper.insertSelective(record);
	}

	@Override
	public AutoPointask selectByPrimaryKey(Integer id) {
		return autoPointaskMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AutoPointask record) {
		return autoPointaskMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AutoPointask record) {
		return autoPointaskMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByParams(Map<String, Object> params) {
		return autoPointaskMapper.deleteByParams(params);
	}

	@Override
	public AutoPointask selectByParams(Map<String, Object> params) {
		return autoPointaskMapper.selectByParams(params);
	}

	@Override
	public int autoPointUpdateTask(Map<String, Object> params) {
		return autoPointaskMapper.autoPointUpdateTask(params);
	}

	@Override
	public int autoPointDeteleTask(Map<String, Object> params) {
		return autoPointaskMapper.autoPointDeteleTask(params);
	}

	@Override
	public int updateByParams(Map<String, Object> params) {
		return autoPointaskMapper.updateByParams(params);
	}

}
