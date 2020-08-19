package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mapper.ItemCatsMapper;
import com.pojo.out.ItemCats;
import com.service.ItemCatsService;

@Service
public class ItemCatsServiceInfo implements ItemCatsService{
	
	
	@Autowired
	ItemCatsMapper itemCatsMapper;
	
	@Override
	public List<ItemCats> getAllItemCatsInfo() throws Exception {
		return itemCatsMapper.selectAll();
	}

}
