package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.in.ItemSalesEx;
import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemWithBLOBs;

public interface ItemService {
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
	
	List<Item> selectAllForAdmin(Map<String, Object> params);
	
	List<Map<String,Object>> selectItemPriceByIdList(Map<String, Object> params);
	
	List<Item> selectListByAdminItemByBusCode(Map<String, Object> params);
	
	long selectListAdminItemCount(Map<String,Object> params);
	
	String getPurchasedItemSum(Map<String,Object> params);
}
