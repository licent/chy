package com.chy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemCats;
import com.chy.service.AutoPointService;
import com.chy.service.CartService;
import com.chy.service.ItemCatsService;
import com.chy.service.ItemService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

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
	ItemService itemService;

	@Autowired
	AutoPointService autoPointService;

	@Autowired
	CartService cartService;

	/**
	 * 商品分类查询
	 */
	@RequestMapping("/manage/item_cats/find")
	@ResponseBody
	public String ItemCatsList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			// isParent
			int isParent =Tools.ObjectToInt(params.get("isParent"));
			
			int withActive  =Tools.ObjectToInt(params.get("withActive"));
			// 扩展参数  当isParent=1的时候  withActive=1 带上 isParent=9的标签 withActive=0的时候不带上isParent=9的标签
			
			if(withActive!=1) {
				info.setData(itemCatsService.getAllItemCatsInfoByParams(params));
			}else {
				params.put("isParentList", "1,9");
				info.setData(itemCatsService.selectAllByParams_ex(params));
			}
			
			
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
			// ztdId
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

	/**
	 * 获取用户购物车总数
	 */
	@RequestMapping("/manage/cart/cartCount")
	@ResponseBody
	public String getCartCount(@RequestParam Map<String, Object> params) {
		ResponseInfo<Long> info = new ResponseInfo<Long>();
		try {
			// userId
			info.setData(cartService.selectCountByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
