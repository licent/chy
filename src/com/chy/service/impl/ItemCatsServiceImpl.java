package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.ItemCatsMapper;
import com.chy.pojo.out.ItemCats;
import com.chy.service.ItemCatsService;

@Service
public class ItemCatsServiceImpl implements ItemCatsService {

	@Autowired
	ItemCatsMapper itemCatsMapper;

	@Override
	public List<ItemCats> getAllItemCatsInfoByParams(Map<String, Object> params) throws Exception {
		return itemCatsMapper.selectAllByParams(params);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return itemCatsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ItemCats record) {
		return itemCatsMapper.insert(record);
	}

	@Override
	public int insertSelective(ItemCats record) {
		return itemCatsMapper.insertSelective(record);
	}

	@Override
	public ItemCats selectByPrimaryKey(Integer id) {
		return itemCatsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ItemCats record) {
		return itemCatsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ItemCats record) {
		return itemCatsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ItemCats> selectAllByParams(Map<String, Object> params) {
		return itemCatsMapper.selectAllByParams(params);
	}

	@Override
	public List<ItemCats> selectAllByParams_ex(Map<String, Object> params) {
		return itemCatsMapper.selectAllByParams_ex(params);
	}

}
