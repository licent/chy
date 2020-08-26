package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapper.ItemMapper;
import com.pojo.out.ItemCats;
import com.service.ItemService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;


/**
 * @author Taylor.O
 * @产品控制器
 * */
@Controller
public class ProductController {
	
	@Autowired
	ItemService itemService;

	/**
	 * 商品列表查询
	 * */
	@RequestMapping("/manage/item/getList")
	@ResponseBody
	public String ProductList(@RequestParam Map<String, String> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			
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
	 * */
	@RequestMapping("/manage/item/getById")
	@ResponseBody
	public String ProductById(@RequestParam Map<String, String> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
}
