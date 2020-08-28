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

}
