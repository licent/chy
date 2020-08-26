package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.out.ItemCats;
import com.service.AutoPointService;
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

	@Autowired
	AutoPointService autoPointService;

	/**
	 * 商品分类查询
	 */
	@RequestMapping("/manage/item_cats/find")
	@ResponseBody
	public String ItemCatsList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			info.setData(itemCatsService.getAllItemCatsInfoByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 粉丝数量 & 活跃指数
	 */
	@RequestMapping("/manage/user_address/fansAndBrisk")
	@ResponseBody
	public String FansInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<Map<String, Object>> info = new ResponseInfo<Map<String, Object>>();
		try {
			Map<String, Object> result = new HashMap<String, Object>();

			result.put("fans", autoPointService.selectFansById(params));
			result.put("saleVolume", autoPointService.selectSaleVolumeById(params));
			info.setData(result);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
