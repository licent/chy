package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.out.ItemCats;

public interface ItemCatsService {
	// 获取所有商品分类
	public List<ItemCats> getAllItemCatsInfoByParams(Map<String, Object> params) throws Exception;
}
