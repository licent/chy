package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.out.ItemCats;
import com.service.ItemCatsService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @author Taylor.O
 * @首页控制器
 * 
 */

@Controller
public class HomeController {
	@Autowired
	ItemCatsService itemCatsService;

	/**
	 * 商品分类查询
	 */
	@RequestMapping("/manage/item_cats/find")
	@ResponseBody
	public String itemCatsFind(@RequestParam Map<String, String> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			info.setData(itemCatsService.getAllItemCatsInfo());
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
}
