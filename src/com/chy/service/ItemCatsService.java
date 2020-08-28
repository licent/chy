package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.ItemCats;

public interface ItemCatsService {
	// 获取所有商品分类
	public List<ItemCats> getAllItemCatsInfoByParams(Map<String, Object> params) throws Exception;
}
