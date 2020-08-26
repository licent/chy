package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ItemMapper;
import com.pojo.out.Item;
import com.pojo.out.ItemWithBLOBs;
import com.service.ItemService;

/**
 * @产品服务层
 * 
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return itemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ItemWithBLOBs record) {
		return itemMapper.insert(record);
	}

	@Override
	public int insertSelective(ItemWithBLOBs record) {
		return itemMapper.insertSelective(record);
	}

	@Override
	public ItemWithBLOBs selectByPrimaryKey(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ItemWithBLOBs record) {
		return itemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(ItemWithBLOBs record) {
		return itemMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Item record) {
		return itemMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Item> selectAllByParams(Map<String, Object> params) {
		return itemMapper.selectAllByParams(params);
	}

}
