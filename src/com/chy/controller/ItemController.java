package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.in.ItemSalesEx;
import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemWithBLOBs;
import com.chy.service.ItemService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @author Taylor.O
 * @产品控制器
 */
@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	/**
	 * 新增商品列表
	 */
	@RequestMapping("/admin/item/createItem")
	@ResponseBody
	public String createItem(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			ItemWithBLOBs i = JSONObject.parseObject(Tools.ObjectToJsonString(params), ItemWithBLOBs.class);
			i.setCode(IDMaker.createItemCode());
			// itemTagId
			info.setData(itemService.insertSelective(i));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 获取商品列表
	 */
	@RequestMapping("/manage/item/getItemListByParams")
	@ResponseBody
	public String getItemListByParams(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// itemTagId
			info.setData(itemService.getItemListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 产品详情
	 */
	@RequestMapping("/manage/item/getById")
	@ResponseBody
	public String getById(@RequestParam Map<String, Object> params) {
		ResponseInfo<Item> info = new ResponseInfo<Item>();
		try {
			// itemId
			info.setData(itemService.selectByPrimaryKey((Integer) params.get("itemId")));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询产品的总购买人数 和 总销量
	 */
	@RequestMapping("/manage/item/getItemBuysAndSales")
	@ResponseBody
	public String getItemBuysAndSales(@RequestParam Map<String, Object> params) {
		ResponseInfo<ItemSalesEx> info = new ResponseInfo<ItemSalesEx>();
		try {
			// itemId
			info.setData(itemService.selectItemBuysAndSales(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
