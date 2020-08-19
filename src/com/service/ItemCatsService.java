package com.service;

import java.util.List;

import com.pojo.out.ItemCats;

public interface ItemCatsService {
	//获取所有商品分类
	public List<ItemCats> getAllItemCatsInfo() throws Exception;
}
