package com.chy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chy.mapper.FactoryMapper;
import com.chy.pojo.out.Factory;
import com.chy.service.FactoryService;

/**
 * @厂商服务
 */
@Service
public class FactoryServiceImpl implements FactoryService {

	@Autowired
	FactoryMapper factoryMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return factoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Factory record) {
		return factoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Factory record) {
		return factoryMapper.insertSelective(record);
	}

	@Override
	public Factory selectByPrimaryKey(Integer id) {
		return factoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Factory record) {
		return factoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Factory record) {
		return factoryMapper.updateByPrimaryKey(record);
	}

}
