package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.in.ItemSalesEx;
import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemWithBLOBs;

public interface ItemMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ItemWithBLOBs record);

	int insertSelective(ItemWithBLOBs record);

	ItemWithBLOBs selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ItemWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(ItemWithBLOBs record);

	int updateByPrimaryKey(Item record);

	List<Item> selectAllByParams(Map<String, Object> params);

	List<Item> selectHotItemByParams(Map<String, Object> params);

	List<Item> getItemListByParams(Map<String, Object> params);

	List<Item> selectCartItemByParams(Map<String, Object> params);

	List<OrderGrossEx> selectItemGrossInfolistByOrderId(Map<String, Object> params);

	ItemSalesEx selectItemBuysAndSales(Map<String, Object> params);
	
	long selectAllByPageCount(Map<String, Object> params);
	
	List<Item> selectAllByPage(Map<String, Object> params);
}